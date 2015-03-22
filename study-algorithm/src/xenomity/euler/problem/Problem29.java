package xenomity.euler.problem;

import java.util.HashSet;
import java.util.Set;

import xenomity.euler.AbstractProblem;

/**
 * Problem 29
 * 
 * <pre>
 * 2 ≤ a ≤ 5 이고 2 ≤ b ≤ 5인 두 정수 a, b로 만들 수 있는 ab의 모든 조합을 구하면 다음과 같습니다.
 * 
 * 22=4,  23=8,  24=16,  25=32
 * 32=9,  33=27,  34=81,  35=243
 * 42=16,  43=64,  44=256,  45=1024
 * 52=25,  53=125,  54=625,  55=3125
 * 여기서 중복된 것을 빼고 크기 순으로 나열하면 아래와 같은 15개의 숫자가 됩니다.
 * 
 * 4,  8,  9,  16,  25,  27,  32,  64,  81,  125,  243,  256,  625,  1024,  3125
 * 
 * 그러면, 2 ≤ a ≤ 100 이고 2 ≤ b ≤ 100인 a, b를 가지고 만들 수 있는 ab는 중복을 제외하면 모두 몇 개입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 22.
 *
 */
public class Problem29 extends AbstractProblem<Integer> {
	
	private int count;

	@Override
	public void problem() {
		Set<Double> set = new HashSet<>();
		
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				set.add(Math.pow(a, b));
			}
		}
		
		count = set.size();
	}

	@Override
	public Integer getResult() {
		return count;
	}

}
