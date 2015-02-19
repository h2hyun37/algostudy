__author__ = 'nedaair'

from nedaair.math.factorial import factorial


def test_factorial() :

    assert factorial(0) == 1
    assert factorial(1) == 1
    assert factorial(2) == 2
    assert factorial(3) == 6
    assert factorial(4) == 24
    assert factorial(10) == 3628800
