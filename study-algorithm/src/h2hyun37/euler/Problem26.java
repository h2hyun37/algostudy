package h2hyun37.euler;

import java.util.ArrayList;
import java.util.List;


/*
 * 분자가 1인 분수를 단위분수라고 합니다. 분모가 2에서 10까지의 단위분수는 아래와 같습니다.
 *
 * 1/2 = 0.5
 * 1/3 = 0.3333....
 * 1/4 = 0.25
 * 1/5 = 0.2
 * 1/6 = 0.16666...
 * 1/7 = 0.142857142857142857....
 * 1/8 = 0.125
 * 1/9 = 0.11111...
 * 1/10 = 0.1
 *
 * 숫자 위에 찍힌 점은 순환마디를 나타내는데,
 * 1/6의 경우 순환마디는 "6"으로 0.166666...처럼 6이 무한히 반복됨을 뜻합니다.
 * 같은 식으로 1/7은 6자리의 순환마디(142857)를 가집니다.
 *
 * d 를 1000 이하의 정수라고 할 때, 단위분수 1/d 의 순환마디가 가장 긴 수는 무엇입니까?
 *
 *
 */

public class Problem26 extends AbstractProblem {


	/**
	 * 순환소수 관련 데이터 자료형.<br />
	 * <br />
	 *
	 *
	 *
	 * <b>boolean isCirculatingDecimals</b> : 순환소수 여부를 나타낸다(true/false) <br />
	 * <b>String decimal</b> : 소수점 이하의 숫자. 4/3=1.333... 에서 3, 1/7=0.142857... 에서
	 * 142857.(반복되는 순환소수부분은 생략) <br />
	 * <b>int beginIndex</b> : 순환소수 시작부분 index를 나타낸다. <br />
	 * 1/6=0.1666...의 경우 6 이 반복되고 6은 1666... 에서 1번째 인덱스이므로 값은 1이 된다.<br />
	 * 1/7=0.142857142857....의 경우 142857이 반복되고 142857의 시작값 1의 인덱스는 0이므로 값은 0이
	 * 된다.<br />
	 * (인덱스는 0부터 시작, 순환소수가 아닌 경우 값은 -1) <br />
	 * <b>int endIndex</b> : 순환소수 끝부분 index를 나타낸다. <br />
	 * 1/6=0.1666...의 경우 6 이 반복되고 6은 1666... 에서 1번째 인덱스이므로 값은 1이 된다.<br />
	 * 1/7=0.142857142857....의 경우 142857이 반복되고 142857의 마지막 7의 인덱스는 5이므로 값은 5가
	 * 된다.<br />
	 * (인덱스는 0부터 시작, 순환소수가 아닌 경우 값은 -1)
	 *
	 */
	public class Decimal {

		boolean isCirculatingDecimals = false;
		String decimal = null;
		int beginIndex = -1;
		int endIndex = -1;

		public boolean isCirculatingDecimals() {
			return isCirculatingDecimals;
		}

		public void setCirculatingDecimals(boolean isCirculatingDecimals) {
			this.isCirculatingDecimals = isCirculatingDecimals;
		}

		public String getDecimal() {
			return decimal;
		}

		public void setDecimal(String decimal) {
			this.decimal = decimal;
		}

		public int getBeginIndex() {
			return beginIndex;
		}

		public void setBeginIndex(int beginIndex) {
			this.beginIndex = beginIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

	}


	/**
	 * 나눗셈을 할 때에 소수 부분을 구한다. <br />
	 * 예를 들어 dividend (피제수) 4, divisor (제수) 3 인 경우 4/3=1.3333... 이므로 <br />
	 * 리턴값은 3333... 이 된다.
	 *
	 *
	 * @param dividend
	 *            피제수 (나눠짐을 당하는 수). 4/3=1.333... 에서 4.
	 * @param divisor
	 *            제수 (나누는 수). 4/3=1.333... 에서 3.
	 * @return Decimal <br />
	 *
	 */
	public Decimal getDecimal(int dividend, int divisor) {


		Decimal returnValue = new Decimal();


		/*
		 * STEP 0 : 소수점 부분만 계산하기 위해 나머지 부분만 구한다.
		 */
		dividend = dividend % divisor;


		// 몫과 나머지, 소수부분 값
		int quotient = 0;
		int remainder = -1;
		StringBuilder sosu = new StringBuilder();

		// 피제수 저장할 리스트. 동일 피제수가 다시 나오면 순환소수로 간주하기 위함
		List<Integer> dividendList = new ArrayList<Integer>(100);


		while (true) {

			/*
			 * STEP 1 : 피제수가 제수보다 작으면 10을 곱하고 무한루프 계속 수행.
			 *
			 * ex> 1/3 에서 1<3 이므로 1 * 10 을 한다.
			 */
			if (dividend < divisor) {
				dividend *= 10;
				continue;
			}

			/*
			 * STEP 2 : 피제수가 연산을 해본 값인지 리스트에서 비교하여 기존 연산해본 값이면 무한루프 탈출.
			 */
			if (dividendList.contains(dividend)) {
				returnValue.setCirculatingDecimals(true);
				returnValue.setDecimal(sosu.toString());
				returnValue.setBeginIndex(dividendList.indexOf(dividend));
				returnValue.setEndIndex(dividendList.size() - 1);
				break;
			} else {
				dividendList.add(dividend);
			}

			/*
			 * STEP 3 : 나눗셈 연산을 수행하고, 몫 부분을 소수값에 추가
			 */
			quotient = dividend / divisor;
			remainder = dividend % divisor;
			sosu.append(quotient);


			/*
			 * STEP 4 : 나머지 값 확인.
			 *
			 * 나머지가 0 인 경우 : 순환소수가 아니므로 무한루프 탈출.
			 * 나머지가 0 이 아닌 경우 : 다음 연산을 위해 피제수를 나머지값으로 세팅.
			 */
			if (remainder == 0) {
				returnValue.setCirculatingDecimals(false);
				returnValue.setDecimal(sosu.toString());
				returnValue.setBeginIndex(-1);
				returnValue.setEndIndex(-1);
				break;
			} else {
				dividend = remainder;
			}

		}

		return returnValue;
	}


	@Override
	public void solveProblem() {

		Decimal[] decimalArray = new Decimal[1000];

		String decimal = null;
		String circularDecimal = null;
		int beginIndex = -1;
		int endIndex = -1;

		// 가장 긴 소수 저장하는 변수
		String longestDecimal = null;
		int longestIndex = 0;

		for (int i = 0; i <= 998; i++) {

			// 순환소수 연산
			decimalArray[i] = getDecimal(1, i+2);

			decimal = decimalArray[i].getDecimal();

			if (decimalArray[i].isCirculatingDecimals) {
				beginIndex = decimalArray[i].getBeginIndex();
				endIndex = decimalArray[i].getEndIndex();
				circularDecimal = decimal.substring(beginIndex, endIndex + 1);

				// 가장 긴 소수 저장
				if (longestDecimal == null
						|| longestDecimal.length() < decimal.length()) {
					longestDecimal = decimal;
					longestIndex = i + 2;
				}

			} else {
				// 출력시 오류 안나도록 임시 값 지정
				beginIndex = -1;
				endIndex = -1;
				circularDecimal = "";
			}

			System.out.println("1 / " + (i + 2) + " --> " + "소수 : " + decimal
					+ " (순환소수 부분 : " + circularDecimal + ", index :  "
					+ beginIndex + ", " + endIndex + ")");


		}

		System.out.println(longestDecimal + "(" + longestIndex + "th)");

	}

	public static void main(String[] args) {

		Problem26 problem = new Problem26();
		problem.solveProblemWithTimeMeasurement();

	}


}
