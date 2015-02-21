package h2hyun37.euler;

import java.math.BigInteger;

public class Problem20 {

	/*
	 * n! 이라는 표기법은 n × (n − 1) × ... × 3 × 2 × 1을 뜻합니다.
	 *
	 * 예를 들자면 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 이 되는데,
	 * 여기서 10!의 각 자리수를 더해 보면 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 입니다.
	 *
	 * 100! 의 자리수를 모두 더하면 얼마입니까?
	 *
	 */



	/*
	 * Problem 16 에서 만든 StringType 숫자 계산 메소드
	 * 재활용하지 않음 (귀찮다)
	 */
	public void solveProblem() {

		BigInteger number = BigInteger.ONE;
		char[] numberChar = null;
		int sumOfDigits = 0;

		/* 100! 계산 */
		for (int num = 1; num <= 100; num++) {
			number = number.multiply(new BigInteger(Integer.toString(num)));
		}

		numberChar = number.toString().toCharArray();
		for (int idx = 0; idx < numberChar.length; idx++) {
			sumOfDigits += numberChar[idx] - '0';
		}

		System.out.println(number);
		System.out.println(sumOfDigits);
	}

	public static void main(String[] args) {

		Problem20 p20 = new Problem20();

		long startTime = System.currentTimeMillis();

		p20.solveProblem();

		// display elapsed time
		System.out.println("Process Time: "
				+ (System.currentTimeMillis() - startTime) + "milli sec.");

	}

}
