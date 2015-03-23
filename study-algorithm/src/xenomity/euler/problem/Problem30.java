package xenomity.euler.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 30
 * 
 * <pre>
 * 각 자리의 숫자를 4제곱해서 더했을 때 자기 자신이 되는 수는 놀랍게도 단 세 개밖에 없습니다.
 * 
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * (1 = 14의 경우는 엄밀히 말해 합이 아니므로 제외합니다)
 * 
 * 위의 세 숫자를 모두 더하면 1634 + 8208 + 9474 = 19316 입니다.
 * 
 * 그렇다면, 각 자리 숫자를 5제곱해서 더했을 때 자기 자신이 되는 수들의 합은 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 22.
 *
 */
public class Problem30 extends AbstractProblem<Integer>{
	
	private int sum;

	@Override
	public void problem() {
		// 상한선 구하기.
		int cipher = IntStream.iterate(2, n -> n + 1)
				.filter(n -> Math.pow(10, n) - 1 > Math.pow(9, 5))
				.findFirst()
				.getAsInt();
		double limitValue = Math.pow(10, cipher + 1);
		
		// calculation.
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 10; i < limitValue; i++) {
			double tempSum = 0;
			
			for (char ch : String.valueOf(i).toCharArray()) {
				tempSum += Math.pow(Integer.valueOf(String.valueOf(ch)), 5);
			}
			
			if (tempSum == i) {
				queue.add(i);
			}
		}
		
		// sum
		sum = queue.stream().mapToInt(x -> x.intValue()).sum();
	}

	@Override
	public Integer getResult() {
		return sum;
	}

}
