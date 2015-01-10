__author__ = 'nedaair'



mat = [[6,7,12,5], [5,3,11,18], [7,17,3,3], [8,10,14,9]]


calcMat = []


def matrixPath(n) :


    for i in range(0, n) :
        calcMat.append([0] * n)

    calcMat[0][0] = mat[0][0]

    for i in range(1, n) :
        calcMat[0][i] = mat[0][i] + calcMat[0][i-1]

    for j in range(1, n) :
        calcMat[j][0] = mat[j][0] + calcMat[j-1][0]

    for i in range(1, n) :
        for j in range(1, n) :
             calcMat[i][j] = mat[i][j] + max([calcMat[i-1][j], calcMat[i][j-1]])



    return calcMat[n-1][n-1]


print matrixPath(4)
