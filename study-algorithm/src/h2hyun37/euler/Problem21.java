package h2hyun37.euler;



/*
 * n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
 * 서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면
 * a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.
 *
 * 예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로
 * 그 합은 d(220) = 284 입니다.
 * 또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
 * 따라서 220과 284는 친화쌍이 됩니다.
 *
 * 10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.
 *
 *
 */

public class Problem21 extends AbstractProblem {

	/**
	 * int[] 배열을 받아서 합을 리턴
	 *
	 * @param arr
	 *            integer배열
	 * @return int : 해당배열값들의 합
	 */
	public int sumOfArray(int[] arr) {

		int sum = 0;
		for (int each : arr) {
			sum += each;
		}
		return sum;
	}

	@Override
	public void solveProblem() {

		// 친화수 합의 누적
		int cumulativeScore = 0;


		for (int num = 1; num <= 10000; num++) {

			// num == a
			// sumOfDivisors1 == d(a)
			int sumOfDivisors1 = sumOfArray(CommonMath.getPositiveDivisors(num));

			// sumOfDivisors1 == b 로 놓고 약수의 합을 구한다
			// sumOfDivisors2 == d(b)
			int sumOfDivisors2 = sumOfArray(CommonMath
					.getPositiveDivisors(sumOfDivisors1));


			// a == d(b) 이고 b == d(a) 이면 (단 a!=b) 친화수이므로 누적값에 추가
			// b == d(a) 조건은 이미 sumOfDivisors2 계산할때 가정했으므로 if 조건문에서는 제외.
			if (num == sumOfDivisors2 && num != sumOfDivisors1) {
				System.out
						.printf("num : %d , sumOfDivisors1 : %d , sumOfDivisors2 : %d --> TRUE\n",
								num, sumOfDivisors1, sumOfDivisors2);
				cumulativeScore += num;
			}


		}

		System.out.println(cumulativeScore);



	}

	public static void main(String[] args) {

		Problem21 problem = new Problem21();
		problem.solveProblemWithTimeMeasurement();

	}


}
