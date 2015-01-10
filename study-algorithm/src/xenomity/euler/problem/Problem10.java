package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 10
 * 
 * <pre>
 * 10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.
 * 이백만(2,000,000) 이하 소수의 합은 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem10 extends AbstractProblem<Long> {
	
	private static final int MAX_VALUE = 2000000;
	private long sum;
	
	@Override
	public void problem() {
		// #1. original (very harder...;;)
		/*ROOT: for (int i = 2; i < MAX_VALUE; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					continue ROOT;
				}
			}
			
			sum += i;
		}*/
	
		// #2. 에라토스테네스 체
		int[] array = new int[MAX_VALUE];
		
		for (int i = 0; i < MAX_VALUE; i++) {
			array[i] = i + 1;
		}
		
		for (int x = 1; x < MAX_VALUE; x++) {
			for (int y = 2; x * y < MAX_VALUE; y++) {
				if (array[x] != 0 && (array[x] * y) - 1 < MAX_VALUE) {
					array[array[x] * y - 1] = 0;
				}
			}
		}
		
		for (int i = 1; i < MAX_VALUE; i++) {
			sum += array[i];
		}
	}

	@Override
	public Long getResult() {
		return sum;
	}
	
}
