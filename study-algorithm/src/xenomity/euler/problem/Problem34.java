package xenomity.euler.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 34
 * 
 * <pre>
 * 숫자 145에는 신기한 성질이 있습니다.
 * 각 자릿수의 팩토리얼(계승)을 더하면 1! + 4! + 5! = 1 + 24 + 120 = 145 처럼 자기 자신이 됩니다.
 * 이렇게 각 자릿수의 팩토리얼을 더하면 자기 자신이 되는 모든 수의 합을 구하세요.
 * 
 * 단, 1! = 1 과 2! = 2 의 경우는 덧셈이 아니므로 제외합니다.
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc’ (이승한)
 * @since 2015. 4. 14.
 *
 */
public class Problem34 extends AbstractProblem<Integer> {
	
	private int result;
	
	@Override
	public void problem() {
		// initialize
		List<Integer> factorialList = IntStream.rangeClosed(0, 9).map(this::factorial).boxed().collect(Collectors.toList());
		Queue<Integer> queue = new LinkedList<>();
		
		// calculate
		for (int i = 10; i < 100000; i++) {
			int tempSum = 0;
			
			for (char ch : String.valueOf(i).toCharArray()) {
				tempSum += factorialList.get(Integer.parseInt(String.valueOf(ch)));
			}
			
			if (i == tempSum) {
				queue.add(i);
			}
		}
		
		// sum
		result = queue.stream().reduce(0, (x, y) -> x + y);
	}
	
	// Get Factorial
	private int factorial(int number) {
		if (number < 2) {
			return 1;
		}
		
		return factorial(number - 1) * number;
	}

	@Override
	public Integer getResult() {
		return result;
	}

}
