package xenomity.euler.problem;

import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 36
 * 
 * <pre>
 * 대칭수(palindrome)인 585는 2진수로 나타내도 1001001001가 되어 여전히 대칭수입니다.
 * 10진법과 2진법으로 모두 대칭수인 1,000,000 이하 숫자의 합을 구하세요.
 * (주의: 첫번째 자리가 0이면 대칭수가 아님)
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 * @since 2015. 4. 19.
 *
 */
public class Problem36 extends AbstractProblem<Integer> {

	private int sum;
	
	@Override
	public void problem() {
		sum = IntStream.rangeClosed(1, 1_000_000)
				.filter(this::isPalindrome)
				.peek(System.out::println)
				.sum();
	}

	private boolean isPalindrome(int number) {
		if (number != Integer.parseInt(new StringBuilder().append(number).reverse().toString())) {
			return false;
		}
		
		String binaryNumber = Integer.toBinaryString(number);
		String reverseBinaryNumber = new StringBuffer().append(binaryNumber).reverse().toString();

		return binaryNumber.equals(reverseBinaryNumber);
	}

	@Override
	public Integer getResult() {
		return sum;
	}

}
