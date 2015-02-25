package h2hyun37.euler;


/*
 * 다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해 보셔도 좋습니다).
 *
 * - 1900년 1월 1일은 월요일이다.
 * - 4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
 * - 2월은 28일이지만, 윤년에는 29일까지 있다.
 * - 윤년은 연도를 4로 나누어 떨어지는 해를 말한다.
 * 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다
 *
 *
 *
 * 20세기 (1901년 1월 1일 ~ 2000년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
 *
 */

public class Problem19 {


	/*
	 * 일요일~토요일까지 enum 지정. 일요일이 맨처음.
	 */
	enum DayOfTheWeek {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
	};


	/*
	 * 숫자에 맞는 요일을 리턴
	 *
	 * 	parameter
	 * 		sequence : 요일 순서. 범위는 0~6까지 가능. 0 = 일요일
	 * 	return
	 * 		DayOfTheWeek : 요일값
	 *
	 */
	public DayOfTheWeek getDayOfTheWeek(int sequence) {

		switch (sequence) {

		case 0:
			return DayOfTheWeek.Sunday;
		case 1:
			return DayOfTheWeek.Monday;
		case 2:
			return DayOfTheWeek.Tuesday;
		case 3:
			return DayOfTheWeek.Wednesday;
		case 4:
			return DayOfTheWeek.Thursday;
		case 5:
			return DayOfTheWeek.Friday;
		case 6:
			return DayOfTheWeek.Saturday;
		default:
			return null;

		}

	}

	/*
	 * 각 월별 날짜 수를 리턴한다.
	 *
	 * 	paramemter
	 * 		year : 년도. 2월인 경우 윤년 여부를 확인하기 위해 받음 ex> 1994, 111.
	 * 		month : 1~12월. 1월인 경우 1을 받는다
	 *	return
	 *		int : 각 월별 날짜 수. input parameter 가 1~12 가 아니면 0 리턴
	 */
	public int getDayCountOfMonth(int year, int month) {

		int dayCount = 0;

		if (month < 1 || 12 < month) {
			return 0;
		}


		if (month == 1 || month == 3 || month == 5
			|| month == 7 || month == 8
			|| month == 10 || month == 12) {

			dayCount = 31;

		} else if (month == 4 || month == 6 || month == 9 || month == 11) {

			dayCount = 30;

		} else {

			if (getDayCountOfYear(year) == 365) {
				dayCount = 28;
			} else {
				dayCount = 29;
			}

		}

		if (dayCount == 29) {
			System.out.printf(
					"[leafYear] year : %d, month : %d, dayCount : %d \n", year,
					month, dayCount);
		}
		return dayCount;

	}

	/*
	 * 각 년도별 날짜 수를 리턴한다
	 *
	 * 	parameter
	 * 		year : 년도. ex> 1994, 111, 2011 ...
	 * 	return
	 * 		int : 해당 년도의 날짜수. 윤년인 경우 366, 아닌경우 365
	 *
	 */
	public int getDayCountOfYear(int year) {

		int daysOfYear = 365;
		boolean isLeafYear = false;

		/*
		 * 4로 나누어 떨어지면 윤년이다.
		 *
		 * 4로 나누어 쩔어지고 && 100 으로 나누어 떨어지면 윤년이 아니다.
		 * 단 400으로 나누어 떨어지면 윤년이다
		 */
		if (year % 4 == 0) {

			if (year % 400 == 0) {
				isLeafYear = true;
			} else if (year % 100 == 0) {
				isLeafYear = false;
			} else {
				isLeafYear = true;
			}

		} else {
			isLeafYear = false;
		}

		if (isLeafYear) {
			return daysOfYear + 1;
		} else {
			return daysOfYear;
		}


	}

	public void solveProblem() {

		// 매월 첫째 날이 무슨 요일인지 저장
		DayOfTheWeek firstDayOfTheMonth = null;

		// 매월 첫째 날이 무슨 요일인지를 int형으로 저장
		int theNumOfThefirstDay = 0;


		int count = 0;

		int year = 1900;
		int prevYear = 1899;

		for (; year <= 2000; prevYear = year++) {

			int month = 1;
			int prevMonth = 12;

			for (; month <= 12; prevMonth = month++) {

				// 1900년 1월 1일은 일요일
				if (year == 1900 && month == 1) {
					firstDayOfTheMonth = getDayOfTheWeek(1);
					continue;
				}

				// 이번 달의 첫번째 요일이 무슨 요일인지 구한다
				theNumOfThefirstDay = (firstDayOfTheMonth.ordinal() + getDayCountOfMonth(
						year, prevMonth)) % 7;
				firstDayOfTheMonth = getDayOfTheWeek(theNumOfThefirstDay);

				System.out
						.printf("year : %d, prevYear : %d, month : %d, prevMonth : %d --> %s\n",
								year, prevYear, month, prevMonth,
								firstDayOfTheMonth);

				// 첫번째 날짜의 요일이 일요일인 경우 count++
				// 단 1901년부터 세도록 한다
				if (theNumOfThefirstDay == 0 && year >= 1901) {
					count++;
				}

			}

		}

		System.out.println("Count of Sunday on 1st day of every month : "
				+ count);

	}

	public static void main(String[] args) {

		Problem19 p19 = new Problem19();

		long startTime = System.currentTimeMillis();

		p19.solveProblem();

		// display elapsed time
		System.out.println("Process Time: "
				+ (System.currentTimeMillis() - startTime) + "milli sec.");

	}

}
