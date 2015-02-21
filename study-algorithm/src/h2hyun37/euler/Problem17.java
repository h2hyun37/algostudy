package h2hyun37.euler;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem 17
 *
 *
 * 1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
 * 각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.
 *
 * 1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?
 *
 * 참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
 *   예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
 *   115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
 *
 *
 */
public class Problem17 {

	Map<Integer, String> numberString = new HashMap<Integer, String>();


	public Problem17() {
		this.initiateNumberString();
	}

	/*
	 * 숫자별 영어 영어 표현을 map에 저장
	 */
	void initiateNumberString() {

		numberString.put(1, "One");
		numberString.put(2, "Two");
		numberString.put(3, "Three");
		numberString.put(4, "Four");
		numberString.put(5, "Five");
		numberString.put(6, "Six");
		numberString.put(7, "Seven");
		numberString.put(8, "Eight");
		numberString.put(9, "Nine");
		numberString.put(10, "Ten");
		numberString.put(11, "Eleven");
		numberString.put(12, "Twelve");
		numberString.put(13, "Thirteen");
		numberString.put(14, "Fourteen");
		numberString.put(15, "Fifteen");
		numberString.put(16, "Sixteen");
		numberString.put(17, "Seventeen");
		numberString.put(18, "Eighteen");
		numberString.put(19, "Nineteen");
		numberString.put(20, "Twenty");
		numberString.put(30, "Thirty");
		numberString.put(40, "Forty");
		numberString.put(50, "Fifty");
		numberString.put(60, "Sixty");
		numberString.put(70, "Seventy");
		numberString.put(80, "Eighty");
		numberString.put(90, "Ninety");
		numberString.put(100, "Hundred");
		numberString.put(1000, "Thousand");

	}


	/*
	 * 1~1000 까지의 값을 받아서 스트링 형태로 리턴
	 *
	 * ex>
	 * 	342 : three hundred and forty-two
	 * 	115 : one hundred and fifteen
	 * 	1	: one
	 * 	11	: eleven
	 * 	21	: twenty-one
	 * 	31	: thirty-one
	 */
	public String getDigitStringExpression(int number) {


		if (number <= 0 || number > 1000) {
			return null;
		}


		StringBuilder sb = new StringBuilder();

		// 1000인 경우
		if (number == 1000) {
			sb.append(numberString.get(1) + " " + numberString.get(number));
			return sb.toString();
		}


		/*
		 * numOfDigits : 각 자리수 저장 배열
		 *
		 * 	- numOfDigits[0] : 일의 자리수
		 *  - numOfDigits[1] : 십의 자리수
		 *  - numOfDigits[2] : 백의 자리수
		 */
		int[] numOfDigits = new int[3];


		numOfDigits[2] = number / 100;
		number %= 100;

		if (numOfDigits[2] > 0) {
			// 100의 자리수 + "hundred"
			sb.append(numberString.get(numOfDigits[2]) + " "
					+ numberString.get(100));

			// 10의 자리수, 1의 자리수가 0이 아니면 and를 붙인다 (ex> three hundred and forty-two)
			if (number > 0) {
				sb.append(" and ");
			}
		}

		// 10의 자리수 : 1~19 사이
		if (1 <= number && number <= 19) {
			sb.append(numberString.get(number));

		// 10의 자리수 : 20 ~ 99 사이
		} else if (20 <= number) {

			// 10의 자리수
			numOfDigits[1] = number / 10;
			sb.append(numberString.get(numOfDigits[1] * 10));

			// 1의 자리수
			number %= 10;
			numOfDigits[0] = number;

			if (numOfDigits[0] > 0) {
				sb.append("-" + numberString.get(numOfDigits[0]));
			}

		}

		return sb.toString();
	}


	public void solveProblem() {

		int charCount = 0;
		String numberString = null;
		char[] numberChar = null;

		for (int number = 1; number <= 1000; number++) {

			numberString = getDigitStringExpression(number);
			System.out.println(numberString);

			numberString = numberString.replace("-", "");
			numberString = numberString.replace(" ", "");

			numberChar = numberString.toCharArray();
			charCount += numberChar.length;
		}

		System.out.println(charCount);

	}

	public static void main(String[] args) {

		Problem17 p17 = new Problem17();

		long startTime = System.currentTimeMillis();

		p17.solveProblem();

		// display elapsed time
		System.out.println("Process Time: "
				+ (System.currentTimeMillis() - startTime) + "milli sec.");

	}

}
