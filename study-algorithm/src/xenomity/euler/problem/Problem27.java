package xenomity.euler.problem;

import java.util.HashMap;
import java.util.Map;

import xenomity.euler.AbstractProblem;

/**
 * Problem 27
 * 
 * <pre>
 * 오일러는 다음과 같은 멋진 2차식을 제시했습니다.
 * 
 * n2 + n + 41
 * 이 식의 n에다 0부터 39 사이의 숫자를 넣으면, 그 결과는 모두 소수가 됩니다.
 * 하지만 n = 40일 때의 값 402 + 40 + 41 은 40×(40 + 1) + 41 이므로 41로 나누어지고, n = 41일 때 역시 412 + 41 + 41 이므로 소수가 아닙니다.
 * 
 * 컴퓨터의 발전에 힘입어 n2 − 79n + 1601 이라는 엄청난 2차식이 발견되었는데, 이것은 n이 0에서 79 사이일 때 모두 80개의 소수를 만들어냅니다. 이 식의 계수의 곱은 -79 × 1601 = -126479가 됩니다.
 * 
 * 아래와 같은 모양의 2차식이 있다고 가정했을 때,
 * 
 * n2 + an + b   (단 | a | < 1000, | b | < 1000)
 * 0부터 시작하는 연속된 n에 대해 가장 많은 소수를 만들어내는 2차식을 찾아서, 그 계수 a와 b의 곱을 구하세요.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 22.
 *
 */
public class Problem27 extends AbstractProblem<Long> {
	
	private long result;

	@Override
	public void problem() {
		Map<Integer, int[]> map = new HashMap<>();
		
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				for (int n = 0; ; n++) {
					if (!isPrime((n * n) + (a * n) + b)) {
						map.put(n, new int[] { a, b });
						
						break;
					}
				}
			}
		}
		
		int maxKey = map.keySet().stream().max(Integer::compareTo).get();
		result = map.get(maxKey)[0] * map.get(maxKey)[1];
	}
	
	private boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		
		boolean result = true;
		
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				result = false;
				
				break;
			}
		}
		
		return result;
	}

	@Override
	public Long getResult() {
		return result;
	}

}
