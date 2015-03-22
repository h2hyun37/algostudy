package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 5
 * 
 * <pre>
 * 1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.
 * 그러면 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem5 extends AbstractProblem<Integer> {

	private static final int MAX_LIMIT = 20;
	private int value = MAX_LIMIT;
	
	@Override
	public void problem() {
		// #1. original
		ROOT: while (true) {
			value++;
			
			for (int i = 1; i <= MAX_LIMIT; i++) {
				if (value % i != 0) {
					continue ROOT;
				}
			}
			
			break;
		}
	
		// #2. 유클리드 호제법을 통한 해결
		// TODO: blah blah
	}
	
	private int 최대공약수_유클리드_호제법(int a, int b) {
		int max = a > b ? a : b;
		int min = a <= b ? a : b;
		
		return (max % min == 0) ? min : 최대공약수_유클리드_호제법(min, max - min);
	}
	
	@SuppressWarnings("unused")
	private int 최소공배수(int a, int b) {
		return a * b / 최대공약수_유클리드_호제법(a, b);
	}

	@Override
	public Integer getResult() {
		return value;
	}
	
}
