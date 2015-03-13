package xenomity.euler.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import xenomity.euler.AbstractProblem;

/**
 * Problem 26
 * 
 * <pre>
 * 분자가 1인 분수를 단위분수라고 합니다. 분모가 2에서 10까지의 단위분수는 아래와 같습니다.
 * 
 * 
 * 숫자 위에 찍힌 점은 순환마디를 나타내는데, 1/6의 경우 순환마디는 "6"으로 0.166666...처럼 6이 무한히 반복됨을 뜻합니다.
 * 같은 식으로 1/7은 6자리의 순환마디(142857)를 가집니다.
 * 
 * d 를 1000 이하의 정수라고 할 때, 단위분수 1/d 의 순환마디가 가장 긴 수는 무엇입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 11.
 *
 */
public class Problem26 extends AbstractProblem<Integer> {
	
	private int maxCycle, result;

	@Override
	public void problem() {
		IntStream.range(2, 1000).forEach(x -> {
			int countCycle = countCycle(x);
			
			if (countCycle > maxCycle) {
				maxCycle = countCycle;
				result = x;
			}
		});
	}
	
	/*
	 * 피제수를 제수로 나눈 나머지를 구했을 때
	 * 그 나머지가 지금까지 연산한 나머지 중에서 같은 것이 존재하게 되면
	 * 그 부분 이후로는 순환부라는 것을 알 수 있다.
	 */
	private int countCycle(int number) {
		List<Integer> remainBuffer = new ArrayList<>();
		int devidend = 1;
		
		for (int i = 0; ; i++) {
			int remain = devidend % number;
			
			if (remainBuffer.contains(remain)) {
				return i - remainBuffer.indexOf(remain);
			} else {
				remainBuffer.add(remain);
				devidend = remain * 10;
			}
		}
	}

	@Override
	public Integer getResult() {
		return result;
	}

}
