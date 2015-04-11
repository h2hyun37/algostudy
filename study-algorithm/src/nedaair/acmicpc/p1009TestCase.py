__author__ = 'nedaair'

import unittest
from p1009 import computerNumber


class P1009TestCase(unittest.TestCase):
    def test_computerNumber(self):
        self.assertEqual(computerNumber(1,6), 1)
        self.assertEqual(computerNumber(3,7), 7)
        self.assertEqual(computerNumber(6,2), 6)
        self.assertEqual(computerNumber(7,100), 1)
        self.assertEqual(computerNumber(9,365), 9)




if __name__ == '__main__':
    unittest.main()
