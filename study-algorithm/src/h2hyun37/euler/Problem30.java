package h2hyun37.euler;


/*
 *
 * 각 자리의 숫자를 4제곱해서 더했을 때 자기 자신이 되는 수는 놀랍게도 단 세 개밖에 없습니다.
 *
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * (1 = 14의 경우는 엄밀히 말해 합이 아니므로 제외합니다)
 *
 * 위의 세 숫자를 모두 더하면 1634 + 8208 + 9474 = 19316 입니다.
 *
 * 그렇다면, 각 자리 숫자를 5제곱해서 더했을 때 자기 자신이 되는 수들의 합은 얼마입니까?
 *
 *
 */

public class Problem30 extends AbstractProblem {


	int minNum = 2;
	int maxNum = 9999999;

	int exponent = 5;

	@Override
	public void solveProblem() {

		long total = 0;

		for (long idx = minNum; idx <= maxNum; idx++) {

			long calcResult = 0;

			for (byte b : Long.toString(idx).getBytes()) {

				calcResult += (long) Math.pow((b - 48), exponent);

			}

			if (calcResult == idx) {
				System.out.println(calcResult);
				total += calcResult;
			}

		}
		System.out.println("total : " + total);


	}

	public static void main(String[] args) {

		Problem30 problem = new Problem30();
		problem.solveProblemWithTimeMeasurement();

	}


}
