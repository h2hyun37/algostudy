package xenomity.euler.problem;

import java.util.HashSet;
import java.util.Set;

import xenomity.euler.AbstractProblem;

/**
 * Problem 32
 * 
 * <pre>
 * 1부터 n까지의 각 숫자를 한번씩만 써서 만들 수 있는 숫자를 팬디지털(pandigital)이라고 합니다.
 * 예를 들면 15234는 1부터 5의 숫자가 한번씩만 쓰였으므로 1 ~ 5 팬디지털입니다.
 * 
 * 7254라는 숫자는 그런 면에서 특이한데, 39 × 186 = 7254 라는 곱셈식을 만들 때 이것이 1 ~ 9 팬디지털이 되기 때문입니다.
 * 
 * 이런 식으로 a × b = c 가 1 ~ 9 팬디지털이 되는 모든 c의 합은 얼마입니까?
 * 
 * (참고: 어떤 c는 두 개 이상의 (a, b)쌍에 대응될 수도 있는데, 이런 경우는 하나로 칩니다)
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 22.
 *
 */
public class Problem32 extends AbstractProblem<Integer> {
	
	private static final int PANDIGITAL_LENGTH = 9;
	private int sum;

	@Override
	public void problem() {
		sum = calculate(1, 4) + calculate(2, 3);
	}
	
	/*
	 * Get Pandigital Multiply Numbers Sum
	 * 
	 * @param aLength a number length
	 * @param bLength b number length
	 */
	private int calculate(int aLength, int bLength) {
		Set<Integer> sets = new HashSet<>();
		
		for (int a = (int) Math.pow(10, aLength - 1); a < (int) Math.pow(10, aLength); a++) {
			for (int b = (int) Math.pow(10, bLength - 1); b < (int) Math.pow(10, bLength); b++) {
				int c = a * b;
				String textNumber = String.valueOf(c) + String.valueOf(b) + String.valueOf(a);
				
				if (textNumber.length() == PANDIGITAL_LENGTH) {
					boolean[] markedQueue = new boolean[PANDIGITAL_LENGTH];
					boolean isDuplicated = false;
					
					for (char ch : textNumber.toCharArray()) {
						int markedQueueIndex = Integer.valueOf(String.valueOf(ch)) - 1;
						
						if (markedQueueIndex < 0 || markedQueue[markedQueueIndex]) {
							isDuplicated = true;
							
							break;
						} else {
							markedQueue[markedQueueIndex] = true;
						}
					}
					
					if (!isDuplicated) {
						sets.add(c);
					}
				}
			}
		}
		
		return sets.stream().mapToInt(Integer::intValue).sum();
	}

	@Override
	public Integer getResult() {
		return sum;
	}

}
