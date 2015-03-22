package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 2
 * 
 * <pre>
 * 피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem02 extends AbstractProblem<Integer> {
	
	private static final int MAX_LIMIT = 4000000;
	private int sum;

	@Override
	public void problem() {
		// #1. original (better performance...)
		/*for (int i = 1, j = 2; (i < MAX_LIMIT || j < MAX_LIMIT); i = i + j, j = i + j) {
			sum += (i % 2 == 0) ? i : 0;
			sum += (j % 2 == 0) ? j : 0;
		}*/
		
		// #2. 피보나치 수열 재귀 함수
		int count = 0;
		int fibonacci = 0;
		
		while ((fibonacci = fibonacci(count)) < MAX_LIMIT) {
			if (fibonacci % 2 == 0) {
				sum += fibonacci;
			}
			
			count++;
		}
	}
	
	private int fibonacci(int a) {
		if (a < 2) {
			return a;
		} else {
			return fibonacci(a - 2) + fibonacci(a - 1);
		}
	}

	@Override
	public Integer getResult() {
		return sum;
	}
	
}
