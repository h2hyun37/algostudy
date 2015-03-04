package h2hyun37.euler;

import java.util.ArrayList;
import java.util.Arrays;


public class CommonMath {


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
