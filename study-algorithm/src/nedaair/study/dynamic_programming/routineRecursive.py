__author__ = 'nedaair'




mat = [[6,7,12,5], [5,3,11,18], [7,17,3,3], [8,10,14,9]]



def matrixPath(i, j) :
    print i, j
    if (i == 1 and j == 1) :
        return mat[i-1][j-1]
    elif i == 1 :
        return mat[i-1][j-1] + matrixPath(1, j-1)
    elif j == 1 :
        return mat[i-1][j-1] + matrixPath(i-1, j)
    else :
        return mat[i-1][j-1] + max([matrixPath(i-1, j), matrixPath(i, j-1)])




print matrixPath(4,4)