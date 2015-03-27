package h2hyun37.euler;


/*
 * 양의 정수 n에 대하여, 다음과 같은 계산 과정을 반복하기로 합니다.
 *
 * n → n / 2 (n이 짝수일 때)
 * n → 3 n + 1 (n이 홀수일 때)
 *
 * 13에 대하여 위의 규칙을 적용해보면 아래처럼 10번의 과정을 통해 1이 됩니다.
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 아직 증명은 되지 않았지만, 이런 과정을 거치면 어떤 수로 시작해도 마지막에는 1로 끝나리라 생각됩니다.
 * (역주: 이것은 콜라츠 추측 Collatz Conjecture이라고 하며, 이런 수들을 우박수 hailstone sequence라 부르기도 합니다)
 *
 * 그러면, 백만(1,000,000) 이하의 수로 시작했을 때 1까지 도달하는데 가장 긴 과정을 거치는 숫자는 얼마입니까?
 *
 * 참고: 계산 과정 도중에는 숫자가 백만을 넘어가도 괜찮습니다.
 *
 */

/*
 * 루프 횟수 줄이는 방법
 * 1. 계산한 결과값을 별도 저장하고, 다음 연산 때 참조한다
 */



public class Problem14 extends AbstractProblem {

	long endNum = 100000000;
	long startNum = 1;

	long[] map = null;

	/*
	 * 값을 받으면 홀수/짝수인지를 확인하여 계산 후 리턴
	 */
	protected long calcNumber(long number) {
		if (number % 2 == 0) {
			return number / 2;
		} else {
			return number * 3 + 1;
		}
	}


	/*
	 * 값을 받아서 우박수가 될 때까지의 횟수를 확인
	 *
	 * 배열을 map으로 이용하여 기존 계산한 값을 저장하고, recursive하게 호출하여 계산.
	 */
	long getHailstoneSeq2(long num, long chainCount) {

		if (map == null) {
			map = new long[(int) endNum + 1];
		}


		if (num == 1) {

			return 1;

		} else if ((num <= endNum) && (num < Integer.MAX_VALUE)
				&& (map[(int) num] != 0)) {

			return (int) map[(int) num];

		} else {

			long nextNum = calcNumber(num);

			chainCount = getHailstoneSeq2(nextNum, chainCount) + 1;

			if (num <= endNum) {

				map[(int) num] = chainCount;
			}
			return chainCount;
		}



	}


	/*
	 * 값을 받아서 우박수가 될 때까지의 횟수를 확인한다
	 */
	public int getHailstoneSeq(long num) {

		int chainCount = 1;

		while (num != 1) {

			num = calcNumber(num);
			chainCount++;

		}

		return chainCount;

	}

	@Override
	public void solveProblem() {


		long chainCount1 = 0;
		long chainCount2 = 0;
		long maxChainCount = 0;
		long hailstoneNum = 0;

		for (long num = endNum; num >= startNum; num--) {

			// use brute-force
			// chainCount1 = getHailstoneSeq(num);

			// use recursive
			chainCount2 = getHailstoneSeq2(num, chainCount2);

			if (chainCount2 > maxChainCount) {
				maxChainCount = chainCount2;
				hailstoneNum = num;
			}

		}

		System.out.printf("hailstone Number : %d , maxChainCount : %d\n",
				hailstoneNum, maxChainCount);

	}

	public static void main(String[] args) {

		Problem14 problem = new Problem14();
		problem.solveProblemWithTimeMeasurement();

	}


}
