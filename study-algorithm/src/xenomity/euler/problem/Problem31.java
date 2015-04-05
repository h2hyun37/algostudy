package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 31
 * 
 * <pre>
 * 영국의 화폐 단위는 파운드(£)와 펜스(p)이고, 동전의 종류는 아래와 같습니다.
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
 * 이 동전들을 가지고 2파운드를 만드는 방법은 다양할 것입니다. 예를 하나 들면 이렇습니다.
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 2파운드를 만드는 서로 다른 방법은 모두 몇가지나 있습니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 3. 22.
 *
 */
public class Problem31 extends AbstractProblem<Integer> {

	private static final int TARGET_POUND = 200;
	private int result = 2; // (£1 * 2) or (£2 * 1)

	@Override
	public void problem() {
		for (int l1 = 0; l1 <= 1; l1++) {
			for (int p50 = 0; 100 * l1 + 50 * p50 <= TARGET_POUND; p50++)
				for (int p20 = 0; 100 * l1 + 50 * p50 + 20 * p20 <= TARGET_POUND; p20++)
					for (int p10 = 0; 100 * l1 + 50 * p50 + 20 * p20 + 10 * p10 <= TARGET_POUND; p10++)
						for (int p5 = 0; 100 * l1 + 50 * p50 + 20 * p20 + 10 * p10 + 5 * p5 <= TARGET_POUND; p5++)
							for (int p2 = 0; 100 * l1 + 50 * p50 + 20 * p20 + 10 * p10 + 5 * p5 + 2 * p2 <= TARGET_POUND; p2++)
								result++;
		}
	}
	
	@Override
	public Integer getResult() {
		return result;
	}

}
