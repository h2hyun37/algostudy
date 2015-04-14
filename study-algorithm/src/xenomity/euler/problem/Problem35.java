package xenomity.euler.problem;

import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 35
 * 
 * <pre>
 * 소수 중에서 각 자리의 숫자들을 순환시켜도 여전히 소수인 것을 circular prime이라고 합니다.
 * 예를 들어 197은 971, 719가 모두 소수이므로 여기에 해당합니다.
 * 이런 소수는 100 밑으로 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97 처럼 13개가 있습니다.
 * 
 * 그러면 1,000,000 밑으로는 모두 몇 개나 있을까요?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 * @since 2015. 4. 14.
 *
 */
public class Problem35 extends AbstractProblem<Integer> {
	
	private int result;
	
	@Override
	public void problem() {
		// initialize primes
		Boolean[] primes = IntStream.rangeClosed(0, 1_000_000)
				.mapToObj(x -> Boolean.TRUE)
				.toArray(Boolean[]::new);
		che(primes);

		// peek circular primes
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] && isCircularPrime(i, primes)) {
				result++;
			}
		}
	}
	
	// 에라토스 테네스 체.
	private void che(Boolean[] source) {
		for (int i = 0; i * i < source.length; i++) {
			if (source[i]) {
				if (isPrime(i)) {
					for (int j = i * 2; j < source.length; j += i) {
						source[j] = Boolean.FALSE;
					}
				} else {
					source[i] = Boolean.FALSE;
				}
			}
		}
	}
	
	// 소수 판별.
	private boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		
		boolean isPrime = true;
		
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				isPrime = false;
				
				break;
			}
		}
		
		return isPrime;
	}
	
	// 순환 소수 판별.
	private boolean isCircularPrime(int number, Boolean[] primes) {
		int numberLength = (int) Math.log10(number);
		int circularNumber = number;
		boolean isCircularPrime = true;
		
		for (int i = 0; i < numberLength; i++) {
			circularNumber = (circularNumber % 10) * (int) Math.pow(10, numberLength) + (circularNumber / 10);

			if (!primes[circularNumber]) {
				isCircularPrime = false;
				
				break;
			}
		}
		
		return isCircularPrime;
	}
	
	@Override
	public Integer getResult() {
		return result;
	}

}
