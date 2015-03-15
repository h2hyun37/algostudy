package h2hyun37.euler;

import java.math.BigInteger;

/*
 *  피보나치 수열은 아래와 같은 점화식으로 정의됩니다.
 *
 *  Fn = Fn-1 + Fn-2  (단, F1 = 1, F2 = 1).
 *  이에 따라 수열을 12번째 항까지 차례대로 계산하면 다음과 같습니다.
 *
 *  F1 = 1
 *  F2 = 1
 *  F3 = 2
 *  F4 = 3
 *  F5 = 5
 *  F6 = 8
 *  F7 = 13
 *  F8 = 21
 *  F9 = 34
 *  F10 = 55
 *  F11 = 89
 *  F12 = 144
 *  수열의 값은 F12에서 처음으로 3자리가 됩니다.
 *
 *  피보나치 수열에서 값이 처음으로 1000자리가 되는 것은 몇번째 항입니까?
 *
 *
 */

public class Problem25 extends AbstractProblem {


	@Override
	public void solveProblem() {


		/*
		 * 피보나치 수열 첫번째, 두번째, 세번째 변수 선언
		 */
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		BigInteger f3 = BigInteger.ZERO;

		int count = 3; // 피보나치 3번째 수열부터 구하기 위해.

		while (true) {

			f3 = BigInteger.ZERO;
			f3 = f3.add(f1).add(f2);

			f1 = f2;
			f2 = f3;

			if (f3.toString().length() >= 1000) {
				System.out.printf("number : %s , %dth fibbonaci number\n",
						f3.toString(), count);
				break;
			}

			if (count % 100 == 0) {
				System.out.println(f3 + "->" + count + "th fibbonaci number");
			}
			count++;


		}



	}

	public static void main(String[] args) {

		Problem25 problem = new Problem25();
		problem.solveProblemWithTimeMeasurement();

	}


}
