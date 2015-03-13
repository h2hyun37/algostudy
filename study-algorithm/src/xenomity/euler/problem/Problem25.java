package xenomity.euler.problem;

import java.math.BigInteger;

import xenomity.euler.AbstractProblem;

/**
 * Problem 25
 * 
 * <pre>
 * 피보나치 수열은 아래와 같은 점화식으로 정의됩니다.
 * 
 * Fn = Fn-1 + Fn-2  (단, F1 = 1, F2 = 1).
 * 이에 따라 수열을 12번째 항까지 차례대로 계산하면 다음과 같습니다.
 * 
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * 수열의 값은 F12에서 처음으로 3자리가 됩니다.
 * 
 * 피보나치 수열에서 값이 처음으로 1000자리가 되는 것은 몇번째 항입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 7.
 *
 */
public class Problem25 extends AbstractProblem<Integer>{
	
	private final BigInteger[] buffer = new BigInteger[100000];
	private int result;

	@Override
	public void problem() {
		for (int i = 0; ; i++) {
			BigInteger fibonacci = fibonacci(i);
			buffer[i] = fibonacci;  // cache value to buffer
			
			if (fibonacci.toString().length() >= 1000) {
				result = i;
				
				break;
			}
		}
	}
	
	private BigInteger fibonacci(int number) {
		if (number <= 2) {
			return BigInteger.ONE;
		} else if (buffer[number] != null) {
			return buffer[number];  // get cached value from buffer.
		} else {
			return fibonacci(number - 2).add(fibonacci(number - 1));
		}
	}

	@Override
	public Integer getResult() {
		return result;
	}

}
