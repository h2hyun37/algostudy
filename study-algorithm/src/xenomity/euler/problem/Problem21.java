package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 21
 * 
 * <pre>
 * n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
 * 서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면 
 * a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.
 * 
 * 예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은 d(220) = 284 입니다.
 * 또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
 * 따라서 220과 284는 친화쌍이 됩니다.
 * 
 * 10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 3.
 *
 */
public class Problem21 extends AbstractProblem<Integer> {
	
	private static final int MAX_LIMIT = 10000;
	private final int[] sums = new int[MAX_LIMIT + 1];
	private int result;

	@Override
	public void problem() {
		// #1. initialize sum list
		for (int i = 1; i <= MAX_LIMIT; i++) {
			sums[i] = d(i);
		}
		
		// #2. 우애수 구하기.
		for (int i = 2; i < MAX_LIMIT; i++) {
			for (int j = i + 1; j <= MAX_LIMIT; j++) {
				if (i == sums[j] && sums[i] == j) {
					result += i + j;  // sum
				}
			}
		}
	}
	
	private int d(int n) {
		int sum = 0;
		int maxLimit = n / 2;
		
		for (int i = 1; i <= maxLimit; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		
		return sum;
	}

	@Override
	public Integer getResult() {
		return result;
	}

}
