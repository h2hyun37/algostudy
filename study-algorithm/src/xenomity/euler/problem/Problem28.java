package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 28
 * 
 * <pre>
 * 숫자 1부터 시작해서 우측으로부터 시계방향으로 감아 5×5 행렬을 만들면 아래와 같이 됩니다.
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * 여기서 대각선상의 숫자를 모두 더한 값은 101 입니다.
 * 
 * 같은 방식으로 1001×1001 행렬을 만들었을 때, 대각선상의 숫자를 더하면 얼마가 됩니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 14.
 *
 */
public class Problem28 extends AbstractProblem<Long> {
	
	private static final int VERTEX_SIZE = 1001;
	private long result = 1;

	@Override
	public void problem() {
		int maxValue = VERTEX_SIZE * VERTEX_SIZE;
		int arithmeticGap = 2;
		
		for (int i = 1, currentValue = 3; currentValue <= maxValue; i++, currentValue += arithmeticGap) {
			result += currentValue;
			
			if (i % 4 == 0) {
				arithmeticGap += 2;
			}
		}
	}

	@Override
	public Long getResult() {
		return result;
	}

}
