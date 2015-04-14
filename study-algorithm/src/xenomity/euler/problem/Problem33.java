package xenomity.euler.problem;

import java.util.LinkedList;
import java.util.Queue;

import xenomity.euler.AbstractProblem;

/**
 * Problem 33
 * 
 * <pre>
 * 분수 49/98에는 재미있는 성질이 있습니다.
 * 수학을 잘 모르는 사람이 분모와 분자에서 9를 각각 지워서 간단히 하려고 49/98 = 4/8 처럼 계산해도 올바른 결과가 됩니다.
 * 이에 비해 30/50 = 3/5 같은 경우는 다소 진부한 예라고 볼 수 있습니다.
 * 위와 같은 성질을 가지면서 '진부하지 않은' 분수는, 값이 1보다 작고 분자와 분모가 2자리 정수인 경우 모두 4개가 있습니다.
 * 
 * 이 4개의 분수를 곱해서 약분했을 때 분모는 얼마입니까?
 * <pre>
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 * @since 2015. 4. 14.
 *
 */
public class Problem33 extends AbstractProblem<Integer> {
	
	private int value;

	@Override
	public void problem() {
		Queue<int[]> bufferedQueue = new LinkedList<>();
		
		for (int i = 12; i < 100; i++) {
			if (!isSkipPredicate(i)) {
				for (int j = 11; j < i; j++) {
					if (!isSkipPredicate(j)) {
						int commonNumber = -1;
						
						try {
							commonNumber = pickCommonNumber(i, j);
						} catch (IllegalArgumentException ex) {
							continue;
						}
						
						String iText = String.valueOf(i);
						String jText = String.valueOf(j);
						String textCommonNumber = String.valueOf(commonNumber);
						
						float reducedI = Float.parseFloat(new StringBuilder(iText).deleteCharAt(iText.indexOf(textCommonNumber)).toString());
						int reducedJ = Integer.parseInt(new StringBuilder(jText).deleteCharAt(jText.indexOf(textCommonNumber)).toString());
						
						if ((Float.parseFloat(iText) / j) == (reducedI / reducedJ)) {
							bufferedQueue.add(new int[] { i, j });
						}
					}
				}
			}
		}
		
		int[] result = new int[] { 1, 1 };
		bufferedQueue.forEach(x -> { result[0] *= x[0]; result[1] *= x[1]; });
		int gcd = gcd(result[0], result[1]);

		while (true) {
			if (result[0] % gcd == 0 && result[1] % gcd == 0) {
				result[0] /= gcd;
				result[1] /= gcd;
			} else {
				value = result[0];
				
				break;
			}
		}
	}
	
	// 숫자의 모든 자리가 다 같은 수거나 0이 포함된 경우.
	private boolean isSkipPredicate(int number) {
		boolean isAllDuplicated = true;
		String textNumber = String.valueOf(number);
		char temp = textNumber.charAt(0);
		
		for (char ch : textNumber.toCharArray()) {
			if (ch != temp) {
				isAllDuplicated = false;
				
				break;
			}
		}
		
		return isAllDuplicated || number % 10 == 0;
	}
	
	// 공통 숫자 추출.
	private int pickCommonNumber(int a, int b) {
		char temp = '\u0000';
		
		ROOT_LABEL: for (char aChar : String.valueOf(a).toCharArray()) {
			for (char bChar : String.valueOf(b).toCharArray()) {
				if (aChar == bChar) {
					temp = aChar;
					
					break ROOT_LABEL;
				}
			}
		}
		
		if (temp == '\u0000') {
			throw new IllegalArgumentException("not found common number.");
		}
		
		return Integer.parseInt(String.valueOf(temp));
	}
	
	// 최대공약수.
	private int gcd(int a, int b) {
		int x = (a < b) ? b : a;
		int y = (a < b) ? a : b;
		int r = x % y;
		
		return (r == 0) ? y : gcd(x, r);
	}
	
	// 최소공배수
	@SuppressWarnings("unused")
	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	@Override
	public Integer getResult() {
		return value;
	}

}
