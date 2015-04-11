__author__ = 'nedaair'

import unittest
from p1008 import division


class P1008MyTestCase(unittest.TestCase):
    def test_division(self):
        self.assertAlmostEqual(division(1,3), 0.3333333333333333333333,9)
        self.assertAlmostEqual(division(2,3), 0.6666666666666666666666,9)


if __name__ == '__main__':
    unittest.main()
