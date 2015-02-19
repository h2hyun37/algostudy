__author__ = 'nedaair'


from p19 import isLeapYear, totalDay

def test_isLeapYear():
    assert isLeapYear(1900) == False
    assert isLeapYear(2000) == True


def test_totalDay31() :
    assert totalDay(2000, 1) == 31
    assert totalDay(2000, 3) == 31
    assert totalDay(2000, 5) == 31
    assert totalDay(2000, 7) == 31
    assert totalDay(2000, 8) == 31
    assert totalDay(2000, 10) == 31
    assert totalDay(2000, 12) == 31

def test_totalDay30() :
    assert totalDay(2000, 4) == 30
    assert totalDay(2000, 6) == 30
    assert totalDay(2000, 9) == 30
    assert totalDay(2000, 11) == 30

def test_totalDay28_29() :
    assert totalDay(1900, 2) == 28
    assert totalDay(1901, 2) == 28
    assert totalDay(1904, 2) == 29

