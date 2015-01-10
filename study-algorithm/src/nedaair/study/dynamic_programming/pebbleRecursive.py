import sys

__author__ = 'nedaair'



matrix = [[6,7,12,-5,5,3,11,3], [-8,10,14,9,7,13,8,5], [11,12,7,4,8,-2,9,4]]

def sumColume(i, p) :

    if p == 1 :
        return matrix[0][i-1]
    elif p == 2 :
        return matrix[1][i-1]
    elif p == 3 :
        return matrix[2][i-1]
    elif p == 4:
        return sumColume(i, 1) + sumColume(i, 3)

def allowPattern(p1, p2) :

    if p1 == 1 and p2 in [2,3] : return True
    elif p1 == 2 and p2 in [1,3,4] : return True
    elif p1 == 3 and p2 in [1,2] : return True
    elif p1 == 4 and p2 == 2 : return True

    return False



def pebble(i, p) :

    if i == 1 : return sumColume(i, p)
    else:
        max = -sys.maxint - 1

        for q in range(1, 5) :
            if allowPattern(p, q) :
                tmp = pebble(i-1, q)

                if(tmp > max): max = tmp


        return max + sumColume(i, p)





print pebble(5, 1)
