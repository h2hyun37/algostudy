package h2hyun37.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 자신을 제외한 약수(진약수)를 모두 더하면 자기 자신이 되는 수를 완전수라고 합니다.
 * 예를 들어 28은 1 + 2 + 4 + 7 + 14 = 28 이므로 완전수입니다.
 * 또, 진약수의 합이 자신보다 작으면 부족수, 자신보다 클 때는 초과수라고 합니다.
 *
 * 12는 1 + 2 + 3 + 4 + 6 = 16 > 12 로서 초과수 중에서는 가장 작습니다.
 * 따라서 초과수 두 개의 합으로 나타낼 수 있는 수 중 가장 작은 수는 24 (= 12 + 12) 입니다.
 *
 * 해석학적인 방법을 사용하면, 28123을 넘는 모든 정수는 두 초과수의 합으로 표현 가능함을 보일 수가 있습니다.
 * 두 초과수의 합으로 나타낼 수 없는 가장 큰 수는 실제로는 이 한계값보다 작지만,
 * 해석학적인 방법으로는 더 이상 이 한계값을 낮출 수 없다고 합니다.
 *
 * 그렇다면, 초과수 두 개의 합으로 나타낼 수 없는 모든 양의 정수의 합은 얼마입니까?
 *
 */

public class Problem23 extends AbstractProblem {


	/*
	 * 초과수인지를 체크하여 초과수라면 true, 아니라면 false 리턴
	 */
	public boolean isAbundantNumber(int number) {

		int[] divisor = CommonMath.getPositiveDivisors(number);
		int sumOfDivisor = 0;

		for (int idx = 0; idx < divisor.length; idx++) {
			sumOfDivisor += divisor[idx];
		}

		return sumOfDivisor > number;

	}

	/*
	 * first ~ last 까지의 초과수 array return
	 */
	public int[] getAbundantNumber(int first, int last) {

		ArrayList<Integer> arr = new ArrayList<Integer>(1000);
		int[] abundantArray = null;

		for (int i = first; i <= last; i++) {
			if (isAbundantNumber(i)) {
				arr.add(i);
			}
		}

		abundantArray = new int[arr.size()];
		for (int idx = 0; idx < arr.size(); idx++) {
			abundantArray[idx] = arr.get(idx);
		}

		return abundantArray;

	}

	@Override
	public void solveProblem() {

		/*
		 * STEP 1 : 1 ~ 28123 중 초과수를 구한다
		 */
		int[] abundant = null;
		abundant = getAbundantNumber(1, 28123);


		/*
		 * STEP 2 : 초과수 2개의 합으로 나타낼 수 있는 정수를 모두 구한다
		 * 
		 * 단 중복값은 제외하고, 초과수 2개의 합이 28123 초과하는 것은 제외한다
		 */
		Map<Integer, Boolean> abundantMap = new HashMap<Integer, Boolean>(10000);
		for (int idx1 = 0; idx1 < abundant.length; idx1++) {
			for (int idx2 = 0; idx2 < abundant.length; idx2++) {

				int sum1 = abundant[idx1] + abundant[idx2];

				if (!abundantMap.containsKey(sum1)
						&& sum1 <= 28123) {
					abundantMap.put(sum1, true);
				}
			}
		}


		/*
		 * STEP 3 : 1 ~ 28123 까지의 정수 중 초과수가 아닌 것을 더한다
		 */
		int sumOfPositiveNum = 0;
		for (int num = 1; num <= 28123; num++) {

			if (!abundantMap.containsKey(num)) {
				sumOfPositiveNum += num;
			}
		}


		/*
		 * STEP 4 : 결과 출력
		 */
		System.out.println(sumOfPositiveNum);


	}

	public static void main(String[] args) {

		Problem23 problem = new Problem23();
		problem.solveProblemWithTimeMeasurement();

	}


}
