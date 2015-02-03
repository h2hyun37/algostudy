package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 12
 * 
 * <pre>
 * 1부터 n까지의 자연수를 차례로 더하여 구해진 값을 삼각수라고 합니다.
 * 예를 들어 7번째 삼각수는 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28이 됩니다.
 * 이런 식으로 삼각수를 구해 나가면 다음과 같습니다.
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 이 삼각수들의 약수를 구해봅시다.
 * 
 *  1: 1
 *  3: 1, 3
 *  6: 1, 2, 3, 6
 * 10: 1, 2, 5, 10
 * 15: 1, 3, 5, 15
 * 21: 1, 3, 7, 21
 * 28: 1, 2, 4, 7, 14, 28
 * 위에서 보듯이, 5개 이상의 약수를 갖는 첫번째 삼각수는 28입니다.
 * 
 * 그러면 500개 이상의 약수를 갖는 가장 작은 삼각수는 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 1.
 *
 */
public class Problem12 extends AbstractProblem<Long> {
	
	private static final int MIN_LIMIT_DIVISOR_SIZE = 500;
	private long value = 1;

	@Override
	public void problem() {
		for (long i = 1; ; i++, value += i) {
			int divisorSize = getDivisorSize(value);
			
			System.out.printf("[%d] divisor count: %d\n", value, divisorSize);
			
			if (divisorSize >= MIN_LIMIT_DIVISOR_SIZE) {
				break;
			}
		}
	}
	
	/*
	 * 소인수분해를 통한 약수 개수 구하기.
	 * 
	 * e.g.
	 * 60을 소인수분해하면 60 = 2²×3×5 이므로
	 * 약수의 개수는 (지수+1)의 곱.
	 * 
	 * 3과 5의 지수는 1 이므로
	 * (2+1)×(1+1)×(1+1) = 3×2×2 = 12개.
	 */
	private int getDivisorSize(long number) {
		if (number <= 1) {
			return 1;
		}
		
		int divisorSize = 1;
		
		for (long i = 2; i <= number; i++) {
			int jisuSize = 0;
			
			while (number % i == 0) {
				number /= i;
				
				jisuSize++;
			}
			
			if (jisuSize > 0) {
				divisorSize *= (jisuSize + 1);
			}
		}
		
		return divisorSize;
	}

	@Override
	public Long getResult() {
		return value;
	}

}
