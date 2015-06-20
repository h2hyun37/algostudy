package h2hyun37.acmicpc.java;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 문제
 * “무한히 넓은 저 우주에 인류만이 홀로 존재한다면, 그건 정말 슬픈 일이 아닐까요”
 * 푸에르토리코 아레시보에 위치한 아레시보 전파망원경(Arecibo radio telescope)은
 * 수십 년째 존재하지 않을 지도 모르는 외계 문명으로부터의 전파를 수신하기 위해 밤하늘을 바라보고 있다.
 *
 * 이 망원경이 수집한 전파 속에서 자연적으로 발생하기 힘든 패턴들을 찾아내어,
 * 그것을 증거로 외계 문명의 존재 여부를 가리려는 노력은 줄곧 이어져왔지만 아직까지도 그러한 패턴은 발견되지 않았다.
 * 한국 천문학계의 자존심 김동혁 박사는 국내 기술로 이러한 탐사를 진행하기 위하여 다음의 전파 표기를 표준으로 삼았다.
 *
 *
 * 전파의 기본 단위는 { 0 , 1 } 두 가지로 구성되어있으며, x+ (  ) 는 임의의 개수(최소 1개) x의 반복으로 이루어진 전파의 집합을 나타낸다.
 *
 *
 * (xyx)+ (  ) 는 괄호 내의 xyx의 반복으로 이루어진 전파의 집합을 뜻한다. 아래는 이해를 돕기 위한 예제이다.
 *
 * 1+ = { 1, 11, 111, 1111, 11111, … }
 * 10+ = { 10, 100, 1000, 10000, 100000, … }
 * (01)+ = { 01, 0101, 010101, 01010101, 0101010101, … }
 * (1001)+ = { 1001, 10011001, 100110011001, … }
 * 10+11 = { 1011, 10011, 100011, 1000011, 10000011, … }
 * (10+1)+ = { 101, 1001, 10001, 1011001, 1001101, 100011011000001, … }
 *
 *
 * 반복을 의미하는 + 외에도 or 를 의미하는 | 기호가 있다. { x | y } 는 x 혹은 y 를 의미하는 것으로,
 * { 0+ | 1+ } 는 { 0 , 1 , 00 , 11 , 000 , 111 , … } 의 집합을 의미한다. 아래는 두 기호를 복합적으로 사용한 예이다.
 *
 * (100 | 11)+ = { 100 , 11 , 10011 , 11100 , 1110011100 , 100111111100100, … }
 *
 *
 * 최근 김동혁 박사는 아레시보 전파망원경에서 star Vega(직녀성) 으로부터 수신한 전파 기록의 일부를 조사하여 그 전파들의 패턴을 분석하여 아래와 같이 기록하였다.
 *
 * (100+1+ | 01)+
 * 김동혁 박사는 다양한 전파 기록 중에서 위의 패턴을 지니는 전파를 가려내는 프로그램을 필요로 한다. 이를 수행할 수 있는 프로그램을 작성하라.
 *
 */

public class Problem1013 {

	static char ROOT_CHAR = 'R';

	public class State {

		char value = ROOT_CHAR;
		boolean isFinalState = false;
		HashMap<Character, State> next = null;

		public State() {
			next = new HashMap<Character, State>();
		}

		public State addNextState(char nextValue) {

			// 다음 상태 생성
			State nextState = new State();
			nextState.value = nextValue;

			// transition 가능하게 next 에 입력
			next.put(nextValue, nextState);

			return nextState;
		}

		public State addSelfState(char value) {

			next.put(value, this);

			return this;
		}

		public State addRootState(char value, State root) {

			next.put(value, root);

			return root;
		}

		public State transition(char value) {
			return next.getOrDefault(value, null);
		}

		public boolean hasRootState() {
			return next.containsKey(ROOT_CHAR);
		}

		public State getRootState() {
			return next.get(ROOT_CHAR);
		}

	}


	public void regex(String pattern, String matcher) {

		pattern = (pattern == null) ? "(100+1+|01)+" : pattern;
		matcher = (matcher == null) ? "0110001011001" : matcher;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(matcher);
		boolean b = m.matches();

		System.out.println("pattern : " + pattern + "\n" + "matcher : " + matcher + "\n" + "result : " + b);

	}


	/**
	 * 상태 트리(?) 를 생성한다 (유한 상태 머신..을 참고할 것)
	 *
	 * @return State (생성한 트리의 root)
	 */
	private State makeStateTree() {
		State root = new State();
		State current = null;

		current = root.addNextState('1');
		current = current.addNextState('0');
		current = current.addNextState('0');
		current = current.addSelfState('0');
		current = current.addNextState('1');
		current = current.addSelfState('1');
		current.isFinalState = true;
		current = current.addRootState(ROOT_CHAR, root);

		current = current.addNextState('0');
		current = current.addNextState('1');
		current.isFinalState = true;
		current = current.addRootState(ROOT_CHAR, root);

		return root;
	}


	/**
	 * 상태 트리와 input String 받아서 비교.
	 *
	 * @param root
	 * @param matcher
	 */
	public void matcher(State root, String matcher) {

		State current = root;
		State next = null;

		boolean isMatch = false;

		for (int idx = 0; idx < matcher.length(); idx++) {

			boolean movedToRootFlag = false;

			char inputChar = matcher.charAt(idx);

			// STEP 1) 다음 상태로 전이
			next = current.transition(inputChar);

			// STEP 1-1) 상태가 매치되지 않아도 다음 상태로 root를 가지고 있다면 root로 상태 전이 후 다음 상태로 전이
			if (next == null && current.hasRootState()) {

				movedToRootFlag = true;

				current = current.getRootState();
				next = current.transition(inputChar);
			}

			// STEP 2-0) print State Message
			printMessage(current, next, movedToRootFlag, inputChar);


			// STEP 2) 다음 상태 확인하여 포인터 이동
			if (next == null) {
				isMatch = false;
				break;
			} else {
				current = next;

				// STEP 2-1) 입력의 마지막 글자 && 마지막 상태이면 matched
				if (idx == matcher.length() - 1 && current.isFinalState) {
					isMatch = true;
				}
			}
		}

		System.out.println("input : " + matcher + "->" + isMatch + "\n");
	}


	/**
	 * 현재 상태,입력값, 다음상태 등을 확인하기 위한 method
	 *
	 * @param current
	 * @param next
	 * @param movedToRootFlag
	 * @param inputChar
	 */
	private void printMessage(State current, State next, boolean movedToRootFlag, char inputChar) {
		String msg =
				"current state : " + current.value +
				"\t" + "inputChar : " + inputChar +
				"\t" + "next state : " + ((next == null) ? "null" : next.value);

		if (movedToRootFlag) {
			msg = "(moved to root) " + msg;
		} else {
			msg = "                " + msg;
		}
		System.out.println(msg);
	}


	public static void main(String[] args) {

		Problem1013 problem = new Problem1013();
		// problem.regex(null, null); // using java.util.regex;

		/*
		 * STEP 1 : 상태 트리? 생성
		 */
		State root = problem.makeStateTree();

		String[] inputStrings = { "10001101", "1001", "100011", "10010111", "011000100110001", "0110001011001" };
		for (String input : inputStrings) {
			/*
			 * STEP 2 : matcher
			 */
			problem.matcher(root, input);
		}

	}
}
