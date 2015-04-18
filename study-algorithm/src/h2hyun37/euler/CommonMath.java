package h2hyun37.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CommonMath {

	static Map<Integer, Boolean> eratosthenes = null;


	/**
	 * 순서를 고려하지 않은 경우의 수 (즉 조합) 을 구한다. (nCr)
	 *
	 *
	 * @param n 전체 갯수
	 * @param r 순서에 상관없이 고르는 갯수
	 * @return long 경우의 수
	 */
	public static long combination(int n, int r) {

		/*
		 * nCr = (n * n-1 * ... * n-r+1) / r!
		 */

		/*
		 * STEP 1 : calculate numerator (n * n-1 * ... * n-r+1)
		 */
		BigInteger numerator = BigInteger.ONE;
		int i = n;
		while (i >= n - r + 1) {
			numerator = numerator.multiply(new BigInteger(Integer.toString(i)));
			i--;
		}

		/*
		 * STEP 2 : calculate denominator (r!)
		 */
		BigInteger denominator = BigInteger.ONE;
		int j = r;

		while (j >= 1) {
			denominator = denominator.multiply(new BigInteger(Integer
					.toString(j)));
			j--;
		}

		/*
		 * STEP 3 : divide
		 */
		numerator = numerator.divide(denominator);

		return numerator.longValue();
	}

	/**
	 * 에라토스테네스의 체를 생성한다. <br />
	 * <br />
	 * 처음 1회 호출시 2~maxNumber 까지 체를 생성 <br />
	 * 이후 호출시 기존maxNumber+1 ~ maxNumber까지 체를 생성 <br />
	 *
	 * @param maxNumber
	 *            : 최대로 생성할 숫자. 예를 들어 120이 입력되면 2~120까지의 숫자까지 true/false로 소수여부를
	 *            구한다
	 */
	public static void makeEratosthenes(int maxNumber) {

		// 기존에 이미 체가 생성되어있고, 기존의 size가 maxNumber보다 크면 그냥 리턴
		if (eratosthenes != null && eratosthenes.size() > maxNumber) {
			return;
		}


		int primeNumber = 0; // 소수여부를 판별할 시작수
		if (eratosthenes == null) {
			eratosthenes = new HashMap<Integer, Boolean>(maxNumber);
			eratosthenes.put(1, false);
			primeNumber = 2;
		} else {
			primeNumber = eratosthenes.size() + 1;
		}


		// 소수 판별할 수 전체를 true로 초기화 (true : 소수, false : 소수가 아님)
		for (int key = primeNumber; key <= maxNumber; key++) {
			eratosthenes.put(key, true);
		}


		for (int number = primeNumber; number <= maxNumber; number++) {

			// 이미 소수가 아니라고 판명된 수는 skip
			if (eratosthenes.get(number) == false) {
				continue;
			}

			for (int divisor = 2; divisor <= number; divisor++) {

				// 소수로만 나눗셈을 하기 위해 소수가 아닌 수는 skip
				if (eratosthenes.get(divisor) == false) {
					continue;
				}

				/*
				 * 소수로 나누어 떨어지는 경우
				 *
				 * 1) number == divisor : 해당 숫자는 소수. 소수의 배수들은 전부 false 처리함.
				 * 2) number != divisor : 자기 자신 외의 다른 소수로 나누어 떨어지므로 소수가 아님
				 */
				if (number % divisor == 0) {

					if (number == divisor) {

						// 소수의 배수들을 전부 false 처리
						int num2 = number + number;
						while (num2 <= maxNumber) {
							eratosthenes.put(num2, false);
							num2 += number;
						}

					} else {
						eratosthenes.put(number, false);
					}

					break;
				}
			}
		}

	}


	/**
	 * 소수인지를 판별하여 true/false 리턴
	 *
	 * @param number 판별할 숫자
	 * @return 소수인경우 true, 소수가 아니거나 1이하의 정수(0, 음의 정수 포함)인 경우 false
	 */
	public static boolean isPrimeNumber(int number) {

		if (number < 2) {
			return false;
		}

		if (eratosthenes == null) {
			makeEratosthenes(number);
		}

		// 기존 생성된 maxNumber 보다 number가 크면 추가 생성
		if (number > eratosthenes.size()) {
			makeEratosthenes(number);
		}

		return eratosthenes.get(number);

	}

	/**
	 * 팩토리얼 값을 리턴한다. 팩토리얼 정의에 따라 0! = 1 이고 입력값은 0 이상의 정수만 받는다.
	 *
	 * 또한 내부적으로 primitive type만 이용하여 계산을 하기 때문에 number <= 20 의 제약을 가진다....
	 *
	 *
	 * @param number
	 *            : 팩토리얼을 구할 0 이상의 정수
	 * @return long : 팩토리얼을 계산한 결과값. number 값이 0보다 작다면 -1 리턴
	 *
	 */
	public static long factorialInteger(int number) {

		if (number < 0) {
			return -1;
		}

		if (number == 0) {
			return 1;
		}

		long returnValue = 1;
		for (int i = 1; i <= number; i++) {
			returnValue *= i;
		}

		return returnValue;
	}

	/**
	 * 모든 양의 약수를 구하여 리턴. 자기자신은 제외하여 리턴한다. (진약수 리턴)
	 *
	 * ex> 28의 경우 1,2,4,7,14 을 리턴
	 *
	 * @param number
	 *            : 약수를 구할 양의 정수 (2이상)
	 * @return int[] : 자기자신을 제외한 약수 배열. 단 number 가 1 이하인 경우 빈 배열 리턴.
	 *
	 */
	public static int[] getPositiveDivisors(int number) {

		if (number <= 1) {
			return new int[0];
		}

		ArrayList<Integer> arr = new ArrayList<Integer>(100);
		int[] divisorArray = null;

		/*
		 * 하단의 for loop 에서 2 이상의 약수만 추가하므로 1을 추가한다
		 */
		arr.add(1);

		/*
		 * 1부터 number/2 까지의 수 중 나눠서 나머지가 0 인 값을 구한다.
		 *
		 * -> 수정 : 2 ~ number의 제곱근+1 까지 약수를 구한다. (이게 조금 더 빠름)
		 */
		for (int divisor = 2; divisor < (int) (Math.sqrt(number)) + 1; divisor++) {

			if (number % divisor == 0) {

				// 약수의 제곱이면 하나만 추가
				if (divisor * divisor == number) {
					arr.add(divisor);
				} else {
					arr.add(divisor);
					arr.add(number / divisor);
				}
			}
		}


		divisorArray = new int[arr.size()];
		for (int idx=0 ; idx < arr.size(); idx++) {
			divisorArray[idx] = arr.get(idx);
		}

		return divisorArray;

	}


	public static void main(String[] args) {


		for (int i = -10; i <= 28; i++) {
			System.out.println("divisors of " + i + " : "
					+ Arrays.toString(CommonMath.getPositiveDivisors(i)));
		}
	}


}
