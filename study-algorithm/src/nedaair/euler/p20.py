__author__ = 'nedaair'

from nedaair.math.factorial import factorial


def sumDigitNumber(n) :

  return reduce(lambda x, y : x + y, [int(x) for x in list(str(factorial(n)))])



if __name__ == "__main__" :
    print sumDigitNumber(100)
