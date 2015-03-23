package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 4
 * 
 * <pre>
 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.
 * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.
 * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem04 extends AbstractProblem<Integer> {

	private static final int MAX_LIMIT = 1000;
	private int maxValue;
	
	@Override
	public void problem() {
		for (int i = 1; i < MAX_LIMIT; i++) {
			ROOT: for (int j = 1; j < MAX_LIMIT; j++) {
				String temp = String.valueOf(i * j);
				int length = temp.length();
				
				if (length % 2 == 0) {
					for (int x = 0, y = length - 1; x < length / 2; x++, y--) {
						if (temp.charAt(x) != temp.charAt(y)) {
							continue ROOT;
						}
					}
					
					int currentValue = Integer.parseInt(temp);
					maxValue = maxValue > currentValue ? maxValue : currentValue;
					
					// logging
					System.out.printf("[%s] a = %d, b = %d\n", temp, i, j);
				}
			}
		}
	}

	@Override
	public Integer getResult() {
		return maxValue;
	}
	
}
