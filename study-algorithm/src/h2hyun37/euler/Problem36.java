package h2hyun37.euler;


/*
 * 대칭수(palindrome)인 585는 2진수로 나타내도 10010010012가 되어 여전히 대칭수입니다.
 *
 * 10진법과 2진법으로 모두 대칭수인 1,000,000 이하 숫자의 합을 구하세요.
 *
 * (주의: 첫번째 자리가 0이면 대칭수가 아님)
 *
 */

public class Problem36 extends AbstractProblem {

	int startNum = 1;
	int endNum = 1000000;

	@Override
	public void solveProblem() {

		int sum = 0;

		for (int num = startNum; num <= endNum; num++) {

			String decimalNum = Integer.toString(num);

			if (CommonMath.isPalindrome(decimalNum)) {

				String binaryNum = Integer.toBinaryString(num);

				if (CommonMath.isPalindrome(binaryNum)) {
					sum += num;
					System.out.println(num + ":" + "is palindrome");
				}
			}
		}

		System.out.println("Total Sum : " + sum);

	}

	public static void main(String[] args) {

		Problem36 problem = new Problem36();
		problem.solveProblemWithTimeMeasurement();


	}


}
