package xenomity.euler.problem;

import xenomity.euler.AbstractProblem;

/**
 * Problem 19
 * 
 * <pre>
 * 다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해 보셔도 좋습니다).
 * 
 * 1900년 1월 1일은 월요일이다.
 * 4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
 * 2월은 28일이지만, 윤년에는 29일까지 있다.
 * 윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다
 * 20세기 (1901년 1월 1일 ~ 2000년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2015. 2. 11.
 *
 */
public class Problem19 extends AbstractProblem<Integer> {
	
	private final int[] maxDays = { 31, 28, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31 };
	private int countConditions;

	@Override
	public void problem() {
		int currentDotw = 1; // 요일.
		
		for (int currentYear = 1901; currentYear <= 2000; currentYear++) {
			int currentMonth = 1;
			int currentDay = 1;
			int totalDaysByYear = 365;
			
			// 만약 윤년이라면...
			if (currentYear % 4 == 0 && currentYear % 100 != 0 && currentYear % 400 == 0) {
				totalDaysByYear++;
				
				maxDays[1] = 29;
			} else {
				maxDays[1] = 28;
			}
			
			// 년별 순회.
			for (int currentDayByYear = 1; currentDayByYear <= totalDaysByYear; currentDayByYear++) {
				if (currentDotw > 7) {
					currentDotw = 1;
				}
				
				if (currentDay > maxDays[currentMonth - 1]) {
					currentMonth++;
					currentDay = 1;
				}
				
				if (currentDay == 1 && currentDotw == 7) {
					countConditions++;
				}
				
				currentDay++;
				currentDotw++;
			}
		}
	}

	@Override
	public Integer getResult() {
		return countConditions;
	}

}
