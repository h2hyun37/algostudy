package h2hyun37.euler;


/*
 * 분수 49/98에는 재미있는 성질이 있습니다.
 *
 * 수학을 잘 모르는 사람이 분모와 분자에서 9를 각각 지워서 간단히 하려고 49/98 = 4/8 처럼 계산해도 올바른 결과가 됩니다.
 *
 * 이에 비해 30/50 = 3/5 같은 경우는 다소 진부한 예라고 볼 수 있습니다.
 *
 * 위와 같은 성질을 가지면서 '진부하지 않은' 분수는, 값이 1보다 작고 분자와 분모가 2자리 정수인 경우 모두 4개가 있습니다.
 *
 * 이 4개의 분수를 곱해서 약분했을 때 분모는 얼마입니까?
 *
 *
 */

public class Problem33 extends AbstractProblem {

	int beginDenominator = 10;
	int endDenominator = 99;
	int beginNumerator = 10;
	int endNumerator = 99;


	/*
	 * 진부하지 않은 분수 : 위아래 같은 수를 없앨 때 값이 같은 경우 (49/98 -> 4/8) (단 0은 제외)
	 */
	@Override
	public void solveProblem() {

		float result = 1.0f;

		/* 분모 loop */
		for (int denominator = beginDenominator; denominator <= endDenominator; denominator++) {

			// STEP 1-1 : 진부한 숫자 (10단위) skip
			if (denominator % 10 == 0) {
				continue;
			}

			// STEP 1-2 : 각각의 digit을 char로 저장
			char d1 = Integer.toString(denominator).toCharArray()[0];
			char d2 = Integer.toString(denominator).toCharArray()[1];

			/* 분자 loop */
			for (int numerator = beginNumerator; numerator < denominator; numerator++) {

				// STEP 2-1 : 진부한 숫자 (10단위) skip
				if (numerator % 10 == 0) {
					continue;
				}
				// STEP 2-2 : 각각의 digit을 char로 저
				char n1 = Integer.toString(numerator).toCharArray()[0];
				char n2 = Integer.toString(numerator).toCharArray()[1];


				// STEP 3 : 계산값이 같은지 비교
				float f1 = (float) numerator / denominator;
				float f2 = 0.0f;

				if (d1 == n1) {
					f2 = (float) (n2 - 48) / (d2 - 48);
				} else if (d1 == n2) {
					f2 = (float) (n1 - 48) / (d2 - 48);
				} else if (d2 == n1) {
					f2 = (float) (n2 - 48) / (d1 - 48);
				} else if (d2 == n2) {
					f2 = (float) (n1 - 48) / (d1 - 48);
				}

				if (f1 == f2) {
					System.out
							.println(numerator + "/" + denominator + "=" + f1);
					result = result * f1;
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {

		Problem33 problem = new Problem33();
		problem.solveProblemWithTimeMeasurement();


	}


}
