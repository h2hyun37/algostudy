package xenomity.euler.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 24
 * 
 * <pre>
 * 어떤 대상을 순서에 따라 배열한 것을 순열이라고 합니다. 예를 들어 3124는 숫자 1, 2, 3, 4로 만들 수 있는 순열 중 하나입니다.
 * 
 * 이렇게 만들 수 있는 모든 순열을 숫자나 문자 순으로 늘어놓은 것을 사전식(lexicographic) 순서라고 합니다.
 * 0, 1, 2로 만들 수 있는 사전식 순열은 다음과 같습니다.
 * 
 * 012   021   102   120   201   210
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 사전식 순열에서 1,000,000번째는 무엇입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 25.
 *
 */
public class Problem24 extends AbstractProblem<String> {
	
	private static final List<Integer> STREAM_NUMBER_BY_ORDERED = new ArrayList<>();
	private String result;
	
	/**
	 * The Constructor
	 */
	public Problem24() {
		IntStream.rangeClosed(0, 9).forEachOrdered(STREAM_NUMBER_BY_ORDERED::add);
	}
	
	@Override
	public void problem() {
		// initialize
		Map<Integer, String> queue = new HashMap<>();
		
		// lexicographic ordering
		generateLexicographicOrder(STREAM_NUMBER_BY_ORDERED, queue, new StringBuilder());
		
		// debug
		//System.out.println(Arrays.toString(queue.values().toArray()));
		
		result = queue.get(1000000);
	}
	
	/*
	 * Generate Lexicographic Order by Recursive
	 * 
	 * @param varg virtual arguments
	 * @param queue result queue
	 * @param buffer temporary buffer
	 */
	private <T extends Number> void generateLexicographicOrder(List<T> varg, Map<Integer, String> queue, StringBuilder buffer) {
		int vargLength = varg.size();
		
		if (vargLength <= 1) {
			queue.put(queue.size() + 1, buffer.toString() + varg.get(0));
		} else {
			for (int i = 0; i < vargLength; i++) {
				List<T> bufferedList = varg.stream().collect(Collectors.toList());
				T charAt = bufferedList.remove(i);
				
				generateLexicographicOrder(bufferedList, queue, buffer.append(charAt));
				
				buffer.deleteCharAt(buffer.length() - 1);
			}
		}
	}

	@Override
	public String getResult() {
		return result;
	}

}
