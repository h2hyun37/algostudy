#-*- coding: utf-8 -*-
__author__ = 'nedaair'

import unittest
from nedaair.util.tree import Tree



class TreeTestCase(unittest.TestCase):

    def test_equal(self):
        self.assertEqual(Tree(3, Tree(4)), Tree(3, Tree(4)))
        self.assertEqual(Tree(4, Tree(5), Tree(6)),Tree(4, Tree(5), Tree(6)))
        self.assertEqual(Tree(4, None, Tree(6)),Tree(4, None, Tree(6)))
        self.assertEqual(Tree(7), Tree(7))

    def test_not_equal(self):
        self.assertNotEqual(Tree(1), Tree(3))
        self.assertNotEqual(Tree(1, None), Tree(3, Tree(4)))
        self.assertNotEqual(Tree(1, Tree(4)), Tree(3, None))
        self.assertNotEqual(Tree(1, None, None), Tree(3, None, Tree(4)))
        self.assertNotEqual(Tree(1, None, Tree(4)), Tree(3, None, None))
        self.assertNotEqual(Tree(4, Tree(5), Tree(6)),Tree(4, Tree(6), Tree(6)))
        self.assertNotEqual(Tree(4, Tree(5), Tree(7)),Tree(4, Tree(5), Tree(11)))



if __name__ == '__main__':
    unittest.main()
