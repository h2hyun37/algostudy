package xenomity.euler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 23
 * 
 * <pre>
 * 자신을 제외한 약수(진약수)를 모두 더하면 자기 자신이 되는 수를 완전수라고 합니다.
 * 예를 들어 28은 1 + 2 + 4 + 7 + 14 = 28 이므로 완전수입니다.
 * 또, 진약수의 합이 자신보다 작으면 부족수, 자신보다 클 때는 초과수라고 합니다.
 * 
 * 12는 1 + 2 + 3 + 4 + 6 = 16 > 12 로서 초과수 중에서는 가장 작습니다.
 * 따라서 초과수 두 개의 합으로 나타낼 수 있는 수 중 가장 작은 수는 24 (= 12 + 12) 입니다.
 * 
 * 해석학적인 방법을 사용하면, 28123을 넘는 모든 정수는 두 초과수의 합으로 표현 가능함을 보일 수가 있습니다.
 * 두 초과수의 합으로 나타낼 수 없는 가장 큰 수는 실제로는 이 한계값보다 작지만, 해석학적인 방법으로는 더 이상 이 한계값을 낮출 수 없다고 합니다.
 * 
 * 그렇다면, 초과수 두 개의 합으로 나타낼 수 없는 모든 양의 정수의 합은 얼마입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 3.
 *
 */
public class Problem23 extends AbstractProblem<Long> {
	
	private static final int MAX_LIMIT = 28123;
	private long sum;
	
	@Override
	public void problem() {
		// #1. 초과수 리스트 확보.
		int[] exceedNumberArray = IntStream.rangeClosed(1, MAX_LIMIT).filter(x -> isExceedNumber(x)).toArray();
		
		// #2.초과수 합 리스트 확보.
		List<Integer> sumList = new ArrayList<>();
				
		for (int i = 0; i < exceedNumberArray.length; i++) {
			for (int j = i; j < exceedNumberArray.length; j++) {
				int tempSum = exceedNumberArray[i] + exceedNumberArray[j];
				
				if (tempSum <= MAX_LIMIT) {
					sumList.add(tempSum);
				}
			}
		}
		
		Stream<Integer> sumStream = sumList.stream().distinct();
		
		// #3. 초과수 합을 제외한 나머지 수의 합.
		sum = LongStream.rangeClosed(0, MAX_LIMIT).sum()- sumStream.mapToLong(Integer::toUnsignedLong).sum();
	}
	
	// 초과수 여부
	private boolean isExceedNumber(int n) {
		int sum = 0;
		int maxLimit = n / 2;
		
		for (int i = 1; i <= maxLimit; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		
		return sum > n;
	}

	@Override
	public Long getResult() {
		return sum;
	}

}
