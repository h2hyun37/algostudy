package xenomity.euler.problem;

import java.math.BigInteger;

import xenomity.euler.AbstractProblem;

/**
 * Problem 15
 * 
 * <pre>
 * 아래와 같은 2 × 2 격자의 왼쪽 위 모서리에서 출발하여 오른쪽 아래 모서리까지 도달하는 길은 모두 6가지가 있습니다 (거슬러 가지는 않기로 합니다).
 *
 * 그러면 20 × 20 격자에는 모두 몇 개의 경로가 있습니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 11.
 *
 */
public class Problem15 extends AbstractProblem<BigInteger> {
	
	private BigInteger value = BigInteger.ZERO;

	@Override
	public void problem() {
		BigInteger temp = factorial(20);
		BigInteger div = factorial(40);
		
		value = div.divide(temp.multiply(temp));
	}
	
	private BigInteger factorial(long n) {
		BigInteger result = new BigInteger("1");
		
		for (long i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}

	@Override
	public BigInteger getResult() {
		return value;
	}

}
