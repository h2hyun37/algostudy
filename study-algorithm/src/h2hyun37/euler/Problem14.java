package h2hyun37.euler;


public class Problem14 {

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


	/*
	 * 값을 받으면 홀수/짝수인지를 확인하여 계산 후 리턴
	 */
	public long calcNumber(long number) {
		if (number % 2 == 0) {
			return number / 2;
		} else {
			return number * 3 + 1;
		}
	}

	/*
	 * 값을 받아서 우박수가 될 때까지의 횟수를 확인한다
	 */
	public long getHailstoneNumCount(long number) {

		int calcCount = 1;

		while (number != 1) {

			number = calcNumber(number);
			calcCount++;

		}

		return calcCount;

	}

	public void solveProblem() {

		int maxNumber = 1000000;
		long calcCount = 0;
		long maxCalcCount = 0;
		int hailstoneNum = 0;

		for (int number = 1; number <= maxNumber; number++) {

			calcCount = getHailstoneNumCount(number);

			if (calcCount > maxCalcCount) {
				maxCalcCount = calcCount;
				hailstoneNum = number;
			}

		}

		System.out.printf("maxCalculationCount : %d (hailstone Number : %d)\n",
				maxCalcCount, hailstoneNum);

	}

	public static void main(String[] args) {

		Problem14 p14 = new Problem14();

		long startTime = System.nanoTime();

		p14.solveProblem();

		// display elapsed time
		System.out.println("Process Time: "
 + (System.nanoTime() - startTime)
				+ " nano sec.");

	}

}
