package h2hyun37.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CommonMath {

	static Map<Integer, Boolean> eratosthenes = null;


	/**
	 * 에라토스테네스의 체를 생성한다.
	 *
	 * <br />
	 * <br />
	 * <b>
	 * 	TODO : 이미 생성되어 있으면 maxNumber를 비교하여 maxNumber가 더 큰 경우에만 생성
	 * 	<br />
	 * 	그리고 기존 최대값 이후부터만 만들도록 한다. 새로 생성하면 비효율적이므로.
	 * 	<br />
	 * 	예를 들어 기존 최대값 120인 상태에서 maxNumber 200이 입력되면 121~200까지만 생성하도록...
	 * </b>
	 *
	 * @param maxNumber
	 *            : 최대로 생성할 숫자. 예를 들어 120이 입력되면 2~120까지의 숫자까지 true/false로 소수여부를
	 *            구한다
	 */
	public static void makeEratosthenes(int maxNumber) {

		eratosthenes = new HashMap<Integer, Boolean>(maxNumber);

		// map 전체를 true로 초기화 (true : 소수, false : 소수가 아님)
		for (int key = 2; key < maxNumber; key++) {
			eratosthenes.put(key, true);
		}


		for (int number = 2; number <= maxNumber; number++) {

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

	public static boolean isPrimeNumber(int number) {

		/*
		 * STEP 1 : 에라토스테네스의 체를 구한다
		 */
		if (eratosthenes == null) {
			makeEratosthenes(number);
		}

		/*
		 * STEP 2 : 키 값이 이미 있는 경우에만 소수여부 판별.
		 *
		 */
		// TODO : 추후에는 이 시점에 진입하면 무조건 키값이 있도록...
		if (eratosthenes.containsKey(number)) {

			return eratosthenes.get(number);

		} else {
			return false;
		}

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
