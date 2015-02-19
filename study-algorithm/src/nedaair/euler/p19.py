#-*- coding: utf-8 -*-
__author__ = 'nedaair'


"""
1900년 1월 1일은 월요일이다.
4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
2월은 28일이지만, 윤년에는 29일까지 있다.
윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다
"""

def isLeapYear(year) :
    if (year % 100 != 0 and year % 4 == 0) or (year % 100 == 0 and  year % 400 == 0) :
        return True
    else :
        return False

def totalDay(year, month) :

    if month in [1,3,5,7,8,10,12] :return 31
    elif month in [4,6,9,11] : return 30
    elif month == 2: return 29 if isLeapYear(year) == True else 28


if __name__ == "__main__" :

    dayOfIndex = 1 # 0 : SUN, 1 : MON ~ 6: SAT

    resultCnt = 0

    for year in range(1900, 2001) :

        for month in range(1, 13) :

            if year >= 1901 and dayOfIndex == 0: resultCnt = resultCnt + 1

            dayOfIndex = ((dayOfIndex + totalDay(year, month))%7)%7


    print resultCnt




