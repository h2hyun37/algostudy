package xenomity.euler.problem;

import java.math.BigInteger;

import xenomity.euler.AbstractProblem;

/**
 * Problem 16
 * 
 * <pre>
 * 2^15 = 32768 의 각 자리수를 더하면 3 + 2 + 7 + 6 + 8 = 26 입니다.
 * 2^1000의 각 자리수를 모두 더하면 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 11.
 *
 */
public class Problem16 extends AbstractProblem<Integer> {
	
	private int value;

	@Override
	public void problem() {
		BigInteger opr = new BigInteger("2").pow(1000);
		
		for (char ch : opr.toString().toCharArray()) {
			value += Integer.valueOf(String.valueOf(ch));
		}
	}

	@Override
	public Integer getResult() {
		return value;
	}

}
