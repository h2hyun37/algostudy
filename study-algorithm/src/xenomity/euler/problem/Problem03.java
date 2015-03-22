package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 3
 * 
 * <pre>
 * 어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.
 * 예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.
 * 600851475143의 소인수 중에서 가장 큰 수를 구하세요.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem03 extends AbstractProblem<Long> {
	
	private static final long MAX_LIMIT = 600851475143l;
	private long current = MAX_LIMIT;
	private long max;

	@Override
	public void problem() {
		for (int i = 2; i <= current; i++) {
			if (current % i == 0) {
				max = i > max ? i : max;
				current /= i;
			}
		}
	}

	@Override
	public Long getResult() {
		return max;
	}
	
}
