__author__ = 'nedaair'

from p17 import makeWord, sumDigitWord

def test_digit1() :
    assert makeWord(4) == "four"
    assert makeWord(3) == "three"
    assert makeWord(1) == "one"


def test_digit2() :
    assert makeWord(13) == "thirteen"
    assert makeWord(15) == "fifteen"
    assert makeWord(30) == "thirty"
    assert makeWord(23) == "twentythree"
    assert makeWord(33) == "thirtythree"

def test_digit3() :
    assert makeWord(400) == "four hundred"
    assert makeWord(401) == "four hundred and one"
    assert makeWord(433) == "four hundred and thirtythree"

def test_checkSumDigit() :
    assert sumDigitWord(makeWord(342)) == 23
    assert sumDigitWord(makeWord(115)) == 20

