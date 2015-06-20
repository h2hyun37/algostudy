package h2hyun37.acmicpc.java;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static void main(String[] args) {

		Problem1013 problem = new Problem1013();
		// problem.regex(null, null); // using java.util.regex;

		/*
		 * STEP 1 : 상태 트리? 생성
		 */
		State root = problem.new State();
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


		/*
		 * STEP 2 : matcher
		 */
		String[] inputStrings = { "10001101", "1001", "100011", "10010111", "011000100110001", "0110001011001" };

		for (String input : inputStrings) {

			current = root;
			State next = null;

			boolean isMatch = false;

			for (int idx=0; idx < input.length(); idx++) {

				boolean movedToRootFlag = false;

				char inputChar = input.charAt(idx);

				// STEP 1) 다음 상태로 전이
				next = current.transition(inputChar);

				// STEP 1-1) 상태가 매치되지 않아도 다음 상태로 root를 가지고 있다면 root로 상태 전이 후 다음 상태로 전이
				if (next == null && current.hasRootState()) {

					movedToRootFlag = true;

					current = current.getRootState();
					next = current.transition(inputChar);
				}

				/* for debugging */
				String msg = "current state : " + current.value + "\t" + "inputChar : " + inputChar + "\t"
						+ "next state : " + ((next == null) ? "null" : next.value);
				if (movedToRootFlag) {
					msg = "(moved to root) " + msg;
				} else {
					msg = "                " + msg;
				}
				System.out.println(msg);
				/* for debugging */


				// STEP 2) 다음 상태 확인하여 포인터 이동
				if (next == null) {
					isMatch = false;
					break;
				} else {
					current = next;

					// STEP 2-1) 입력의 마지막 글자 && 마지막 상태이면 matched
					if (idx == input.length() - 1 && current.isFinalState) {
						isMatch = true;
					}
				}
			}

			System.out.println("input : " + input + "->" + isMatch + "\n");
		}
	}
}
