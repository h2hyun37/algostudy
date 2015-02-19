#-*- coding: utf-8 -*-
__author__ = 'nedaair'


"""
1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.

1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?

참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
  예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
  115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
"""


WORD_POOL    = ("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
TENABLE_POOL = ("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
TENUNIT_POOL = ("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")


def makeWord(n) :
    nLeng =  len(str(n))

    if nLeng == 4 :
        return "one thousand"
    elif nLeng == 3 :
        if n % 100 == 0 : return WORD_POOL[int(str(n)[0]) -1] + " hundred"
        else : return WORD_POOL[int(str(n)[0]) -1] + " hundred and " + makeWord(int(str(n)[1:]))
    elif nLeng == 2 :
        if n < 20 : return TENABLE_POOL[n-10]
        elif n % 10 == 0 : return TENUNIT_POOL[int(str(n)[0])-2]
        else : return TENUNIT_POOL[int(str(n)[0])-2] + makeWord(int(str(n)[1]))
    elif nLeng == 1 :
        return WORD_POOL[n-1]

def sumDigitWord(word) :
    return len(word.replace(" ", ""))



if __name__ == "__main__" :
    totalWord = []

    for i in range(1, 1001) :
        totalWord.append(makeWord(i))

    print reduce(lambda x , y: x + y, [sumDigitWord(makeWord(i)) for i in range(1, 1001)])
