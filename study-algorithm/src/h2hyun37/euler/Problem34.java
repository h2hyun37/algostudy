package h2hyun37.euler;



/*
 * 숫자 145에는 신기한 성질이 있습니다.
 * 각 자릿수의 팩토리얼(계승)을 더하면  1! + 4! + 5! = 1 + 24 + 120 = 145 처럼 자기 자신이 됩니다.
 *
 * 이렇게 각 자릿수의 팩토리얼을 더하면 자기 자신이 되는 모든 수의 합을 구하세요.
 *
 * 단, 1! = 1 과 2! = 2 의 경우는 덧셈이 아니므로 제외합니다.
 *
 */

public class Problem34 extends AbstractProblem {

	int beginNum = 3;
	int endNum = 99999;

	@Override
	public void solveProblem() {

		long sum = 0;

		for (int i = beginNum; i <= endNum; i++) {

			int sumDigitsFactorial = 0;
			for (char c : Integer.toString(i).toCharArray()) {

				int digit = c - 48;
				sumDigitsFactorial += CommonMath.factorialInteger(digit);

			}

			if (sumDigitsFactorial == i) {
				System.out.println(sumDigitsFactorial);
				sum += sumDigitsFactorial;
			}

		}

		System.out.println(sum);
	}

	public static void main(String[] args) {

		Problem34 problem = new Problem34();
		problem.solveProblemWithTimeMeasurement();


	}


}
