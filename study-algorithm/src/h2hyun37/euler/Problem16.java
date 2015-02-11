package h2hyun37.euler;

import java.math.BigInteger;

public class Problem16 {

	/*
	 * Problem 16
	 *
	 * 2^15 = 32768 의 각 자리수를 더하면 3 + 2 + 7 + 6 + 8 = 26 입니다.
	 *
	 * 2^1000의 각 자리수를 모두 더하면 얼마입니까?
	 */


	/*
	 * BigInteger 로 계산한 방법
	 */
	private void solveProblem() {

		/*
		 * 2^1000 을 구한다
		 */
		BigInteger number = new BigInteger("1");
		BigInteger two = new BigInteger("2");

		for (int squareCnt = 1; squareCnt <= 1000; squareCnt++) {

			number = number.multiply(two);
		}
		System.out.println(number);

		/*
		 * 각 자리수 더하여 출력
		 */
		System.out.println(sumEachDigit(number.toString()));

	}

	/*
	 * 각 자리수를 더하여 출력
	 */
	private int sumEachDigit(String number) {

		int sum = 0;

		for (int idx = 0; idx < number.length(); idx++) {

			// ASCII CODE 48 == '0' 이므로 char -> int로 변환하기 위해 -48
			sum += number.charAt(idx) - 48;

		}

		return sum;

	}


	/*
	 * String형 숫자를 받아서 2를 곱한 값을 String형으로 리턴
	 */
	private String multiplyTwo(String numberString) {

		StringBuilder sb = new StringBuilder();
		int thisCarry = 0, nextCarry = 0;

		/*
		 * String 에서 각 자리수를 가져와서 계산
		 */
		for (int idx = numberString.length() - 1; idx >= 0; idx--) {

			// ASCII CODE 48 == '0' 이므로 char -> int로 변환하기 위해 -48
			int num2 = numberString.charAt(idx) - 48;

			// 이전 계산에서 가져온 올림
			thisCarry = nextCarry;

			/*
			 * 2를 곱한 후, 올림과 이번 자리수를 구한다 (이전 계산에서의 올림 포함)
			 */
			num2 *= 2;
			nextCarry = num2 / 10;
			num2 = num2 % 10;
			num2 += thisCarry;

			/*
			 * 맨 앞자리인 경우, 올림 값을 포함하여 String에 추가해야 한
			 */
			if (idx == 0) {
				num2 = nextCarry * 10 + num2;
			}

			/*
			 * String에 이번 계산값 추가
			 */
			sb.insert(0, Integer.toString(num2));


		}

		return sb.toString();

	}

	/*
	 * 숫자를 String 취급하여 계산
	 */
	private void solveProblem1() {

		/*
		 * 2^62 승까지는 그냥 계산한다 (long 으로 표현 가능하므로)
		 */
		long number = 1;
		for (int squareCnt = 1; squareCnt <= 62; squareCnt++) {
			number *= 2;
		}

		/*
		 * 2^63 부터는 String 으로 변환하여 계산
		 */
		String numberString = Long.toString(number);

		for (int squareCnt = 1; squareCnt <= 1000 - 62; squareCnt++) {

			numberString = multiplyTwo(numberString);

			// 테스트 출력
			// System.out.println(numberString);


		}

		/*
		 * 각 자리수를 더하여 출력
		 */
		System.out.println(numberString);
		System.out.println(sumEachDigit(numberString));

	}

	public static void main(String[] args) {

		Problem16 p16 = new Problem16();

		long startTime = System.nanoTime();

		p16.solveProblem();

		// display elapsed time
		System.out.println("Process Time: " + (System.nanoTime() - startTime)
				/ 1000.0 + " micro sec.");

		long startTime2 = System.nanoTime();

		p16.solveProblem1();

		// display elapsed time
		System.out.println("Process Time: " + (System.nanoTime() - startTime2)
				/ 1000.0 + " micro sec.");

	}
}
