__author__ = 'nedaair'

import unittest
from p21 import d


class P21TestCase(unittest.TestCase):
    def test_friendShip(self):
        self.assertEqual(d(220), 284)
        self.assertEqual(d(284), 220)


if __name__ == '__main__':
    unittest.main()
