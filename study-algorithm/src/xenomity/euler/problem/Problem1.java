package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 1
 * 
 * <pre>
 * 10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다. 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem1 extends AbstractProblem<Integer> {
	
	private int sum;

	@Override
	public void problem() {
		for (int i = 0; i < 1000; i++) {
			sum += (i % 3 == 0) | (i % 5 == 0) ? i : 0;
		}
	}

	@Override
	public Integer getResult() {
		return sum;
	}

}
