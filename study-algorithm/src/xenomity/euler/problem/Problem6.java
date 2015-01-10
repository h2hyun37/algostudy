package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 6
 * 
 * <pre>
 * 1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같습니다 (제곱의 합).
 * 12 + 22 + ... + 102 = 385
 * 1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * 따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 됩니다.
 * 그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem6 extends AbstractProblem<Integer> {
	
	private static final int MAX_LIMIT = 100;
	private int value;

	@Override
	public void problem() {
		int zSum = 0;
		int sumX = 0;
		
		for (int i = 1; i <= MAX_LIMIT; i++) {
			zSum += Math.pow(i, 2);
			sumX += i;
		}
		
		value = (sumX * sumX) - zSum;
	}

	@Override
	public Integer getResult() {
		return value;
	}
	
}
