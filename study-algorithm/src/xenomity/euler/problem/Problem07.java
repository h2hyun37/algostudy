package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 7
 * 
 * <pre>
 * 소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.
 * 이 때 10,001번째의 소수를 구하세요.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem07 extends AbstractProblem<Integer> {
	
	private static final int COUNTER = 10001;
	private int value = 2;

	@Override
	public void problem() {
		int index = 0;
		
		ROOT: for (int i = 2; ; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					continue ROOT;
				}
			}
		
			value = i;
			
			if (++index == COUNTER) {
				break;
			}
		}
	}

	@Override
	public Integer getResult() {
		return value;
	}
	
}
