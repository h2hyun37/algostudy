package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 9
 * 
 * <pre>
 * 세 자연수 a, b, c 가 피타고라스 정리 a2 + b2 = c2 를 만족하면 피타고라스 수라고 부릅니다 (여기서 a < b < c ).
 * 예를 들면 32 + 42 = 9 + 16 = 25 = 52이므로 3, 4, 5는 피타고라스 수입니다.
 * a + b + c = 1000 인 피타고라스 수 a, b, c는 한 가지 뿐입니다. 이 때, a × b × c 는 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 *
 */
public class Problem09 extends AbstractProblem<Long> {
	
	private long result;
	
	@Override
	public void problem() {
		for (int c = 0; ; c++) {
			for (int b = 0; b < c; b++) {
				for (int a = 0; a < b; a++) {
					if (a + b + c == 1000 && (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))) {
						result = a * b * c;
						
						System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
						
						return;
					}
				}
			}
		}
	}

	@Override
	public Long getResult() {
		return result;
	}
	
}
