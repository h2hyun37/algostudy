package h2hyun37.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 * 1부터 n까지의 각 숫자를 한번씩만 써서 만들 수 있는 숫자를 팬디지털(pandigital)이라고 합니다.
 * 예를 들면 15234는 1부터 5의 숫자가 한번씩만 쓰였으므로 1 ~ 5 팬디지털입니다.
 *
 * 7254라는 숫자는 그런 면에서 특이한데, 39 × 186 = 7254 라는 곱셈식을 만들 때 이것이 1 ~ 9 팬디지털이 되기 때문입니다.
 *
 * 이런 식으로 a × b = c 가 1 ~ 9 팬디지털이 되는 모든 c의 합은 얼마입니까?
 *
 * (참고: 어떤 c는 두 개 이상의 (a, b)쌍에 대응될 수도 있는데, 이런 경우는 하나로 칩니다)
 *
 */

public class Problem32 extends AbstractProblem {


	/**
	 * 두 정수 a,b를 받아서 동일한 숫자를 가지고 있는지 체크한다.
	 * 예를 들어
	 * 	- a == 123, b == 456 : 중복되는 숫자가 없으므로 false 리턴.
	 * 	- a == 123, b == 719 : 1 이 중복되므로 true 리턴.
	 *
	 *
	 * @param a 비교할 숫자
	 * @param b 비교할 숫자
	 * @return boolean 중복되는 숫자가 있으면 true 리턴, 없으면 false 리턴
	 */
	boolean hasDupDigit(int a, int b) {

		char[] chA = Integer.toString(a).toCharArray();
		char[] chB = Integer.toString(b).toCharArray();

		for (char ca : chA) {
			for (char cb : chB) {

				if (ca == cb) {
					return true;
				}

			}
		}

		return false;

	}

	/**
	 * 정수 a 의 각 자리수 중 중복이 있는지 체크.
	 * 예를 들어 1234 -> false, 1233 -> true.
	 *
	 * @param a 체크할 정수
	 * @return boolean (자리수 중 중복이 있다면 true, 없다면 false)
	 */
	boolean hasDupSelf(int a) {

		// 1~9 까지의 갯수이므로 9개.
		int digitsCount = 9;

		/*
		 * 배열을 맵으로 사용.
		 *
		 * 키==index값, value==한번만 존재하면 true, 없거나 두번이상 존재하면 false
		 *
		 * index 0 은 무조건 false. (digit 범위는 1~9 이므로)
		 */
		boolean[] map = new boolean[digitsCount + 1];
		for (int idx = 0; idx <= digitsCount; idx++) {
			map[idx] = false;
		}

		for (char c : Integer.toString(a).toCharArray()) {

			int digit = c - 48;

			if (map[digit] == true) {
				return true;
			} else {
				map[digit] = true;
			}

		}

		return false;

	}

	/*
	 * int[] num 의 숫자들이 1~9 한번씩만 써서 만든 숫자인지 확인
	 */
	boolean isPanDigit(int[] numbers) {

		// 1~9 까지의 갯수이므로 9개.
		int digitsCount = 9;

		/*
		 * 배열을 맵으로 사용.
		 *
		 * 키==index값, value==한번만 존재하면 true, 없거나 두번이상 존재하면 false
		 *
		 * index 0 은 무조건 false. (digit 범위는 1~9 이므로)
		 */
		boolean[] map = new boolean[digitsCount + 1];
		for (int idx = 0; idx <= digitsCount; idx++) {
			map[idx] = false;
		}

		/*
		 * panDigit 체크
		 *
		 * 이미 나온 숫자가 있다면 (if (map[digit] == true) 부분)
		 *
		 * 바로 false 리턴
		 */
		for (int number : numbers) {
			for (char c : Integer.toString(number).toCharArray()) {

				int digit = c - 48;

				if (map[digit] == true) {
					return false;
				} else {
					map[digit] = true;
				}

			}
		}

		/*
		 * map을 체크해서
		 *
		 * 각 digit이 true로 되어 있는지 체크한다.
		 */
		for (int idx = 1; idx <= digitsCount; idx++) {

			if (map[idx] == false) {
				return false;
			}

		}

		return true;
	}

	@Override
	public void solveProblem() {

		int a = 0;
		int b = 0;
		int c = 0;

		Map<Integer, String> map = new HashMap<Integer, String>(100);

		/*
		 * c가 가능한 범위를 대략 생각해보면 4자리가 가능.
		 *  - 3자리 이하 : a,b 합쳐서 6개 이상 숫자 가능.
		 *  a,b = (5자리,1자리 or 4자리,2자리 or 3자리,3자리) 이므로 성립불가.
		 *  - 5자리 이상 : a,b 합쳐서 4개 이하 숫자 가능.
		 *  a,b = (3자리,1자리 or 2자리,2자리) 이므로 성립불가.
		 *
		 *
		 *  ==> c가 4자리면 , a,b는 5개 숫자가 가능.
		 *  a,b = (4자리,1자리 or 3자리,2자리) 이므로 a의 max는 4자리 최대값, b의 max는 2자리 최대값.
		 */
		int maxA = 9876;
		int maxB = 98;

		for (a = 1; a <= 9876; a++) {

			/*
			 * STEP 1-1 : a 값에 0 존재하는지 확인
			 */
			boolean hasZeroA = hasDupDigit(a, 0);
			if (hasZeroA) {
				continue;
			}

			/*
			 * STEP 1-2 : a 값에 중복되는 자리수 확인
			 */
			boolean hasDupSelfA = hasDupSelf(a);
			if (hasDupSelfA) {
				continue;
			}


			for (b = 1; b <= 98; b++) {

				/*
				 * STEP 2-1 : b 값에 0 존재하는지 확인
				 */
				boolean hasZeroB = hasDupDigit(b, 0);
				if (hasZeroB) {
					continue;
				}


				/*
				 * STEP 2-2 : b 값에 중복되는 자리수 확인
				 */
				boolean hasDupSelfB = hasDupSelf(b);
				if (hasDupSelfB) {
					continue;
				}


				/*
				 * STEP 3 : a,b 중복값 확인
				 */
				boolean hasDup1 = hasDupDigit(a, b);
				if (hasDup1) {
					continue;
				}


				/*
				 * STEP 4 : c 계산
				 */
				c = a * b;
				boolean hasZeroC = hasDupDigit(c, 0);
				if (hasZeroC) {
					continue;
				}


				/*
				 * STEP 5 : c-a, c-b 중복 확인
				 */
				boolean hasDup2 = hasDupDigit(c, a);
				boolean hasDup3 = hasDupDigit(c, b);

				if (hasDup2 || hasDup3) {
					continue;
				}

				/*
				 * STEP 6 : a,b,c 가 pandigit 인지 확인
				 */
				int[] numbers = { a, b, c };
				if (!isPanDigit(numbers)) {
					continue;
				}


				/*
				 * STEP 7 : c를 key로 map에 저장
				 */
				map.put(c, Integer.toString(a) + "*" + Integer.toString(b));
				// System.out.println("[pandigit] " + c + " = " + a + " * " +
				// b);

			}
		}

		System.out.println(map);
		int sum = 0;
		Set<Integer> keySet = map.keySet();
		for (int key : keySet) {
			sum += key;
		}

		System.out.println("sum of c : " + sum);

	}

	public static void main(String[] args) {

		Problem32 problem = new Problem32();
		problem.solveProblemWithTimeMeasurement();


	}


}
