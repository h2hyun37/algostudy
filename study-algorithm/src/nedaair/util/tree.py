__author__ = 'nedaair'


class Tree :

    def __init__(self, value, leftTree=None, rightTree=None):
        self.value = value
        self.leftTree = leftTree
        self.rightTree = rightTree

    def __eq__(self, other):

        if self.value != other.value :
            return False

        if self.leftTree is None and other.leftTree is not None:
            return False
        elif self.leftTree is not None:
            if other.leftTree is None : return False
            elif self.leftTree.__dict__['value'] != other.leftTree.__dict__['value'] : return False

        if self.rightTree is None and other.rightTree is not None:
            return False
        elif self.rightTree is not None:
            if other.rightTree is None : return False
            elif self.rightTree.__dict__['value'] != other.rightTree.__dict__['value'] : return False

        return True

    def __ne__(self, other):

        return not self.__eq__(other)
