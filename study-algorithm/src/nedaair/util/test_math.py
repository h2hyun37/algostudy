__author__ = 'nedaair'

import unittest
from nedaair.util.smath import *


class MathTestCase(unittest.TestCase):

  def test_sosu(self):
      self.assertEqual(sosu(10), [2, 3, 5, 7])
      self.assertEqual(sosu(20), [2, 3, 5, 7, 11, 13, 17, 19])
      self.assertEqual(sosu(100), [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97])
      self.assertEqual(sosu(200), [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199])

  def test_yaksu(self):
      self.assertEqual(yaksu(4), [1, 2, 4])
      self.assertEqual(yaksu(72), [1, 2, 3, 4, 6, 8, 9, 12, 18, 24, 36, 72])
      self.assertEqual(yaksu(135), [1, 3, 5, 9, 15, 27, 45, 135])

  def test_factorial(self) :
      self.assertEqual(factorial(0), 1)
      self.assertEqual(factorial(1), 1)
      self.assertEqual(factorial(2), 2)
      self.assertEqual(factorial(3), 6)
      self.assertEqual(factorial(4), 24)
      self.assertEqual(factorial(10), 3628800)



if __name__ == '__main__':
    unittest.main()
