package xenomity.euler.problem;

import java.math.BigInteger;

import xenomity.euler.AbstractProblem;

/**
 * Problem 20
 * 
 * <pre>
 * n! 이라는 표기법은 n × (n − 1) × ... × 3 × 2 × 1을 뜻합니다.
 * 
 * 예를 들자면 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 이 되는데,
 * 여기서 10!의 각 자리수를 더해 보면 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 입니다.
 * 
 * 100! 의 자리수를 모두 더하면 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 11.
 *
 */
public class Problem20 extends AbstractProblem<Integer> {
	
	private int value;

	@Override
	public void problem() {
		for (char ch : factorial(100).toString().toCharArray()) {
			value += Integer.valueOf(String.valueOf(ch));
		}
	}
	
	private BigInteger factorial(int number) {
		BigInteger result = BigInteger.ONE;
		
		for (int i = 2; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}

	@Override
	public Integer getResult() {
		return value;
	}

}
