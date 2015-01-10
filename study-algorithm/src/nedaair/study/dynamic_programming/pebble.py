__author__ = 'nedaair'


matrix = [[6,7,12,-5,5,3,11,3], [-8,10,14,9,7,13,8,5], [11,12,7,4,8,-2,9,4]]


calcMat = []

def sumColume(i, p) :

    if p == 1 :
        return matrix[0][i-1]
    elif p == 2 :
        return matrix[1][i-1]
    elif p == 3 :
        return matrix[2][i-1]
    elif p == 4:
        return sumColume(i, 1) + sumColume(i, 3)


def allowPatternList(i, p):

    result = []

    if p == 1 :
        result.append(calcMat[i][1])
        result.append(calcMat[i][2])
    elif p == 2 :
        result.append(calcMat[i][0])
        result.append(calcMat[i][2])
        result.append(calcMat[i][3])
    elif p == 3 :
        result.append(calcMat[i][0])
        result.append(calcMat[i][1])
    elif p == 4 :
        result.append(calcMat[i][1])

    return result


def pebble(n) :

    for i in range(0, n) :
        calcMat.append([0] * 4)

    for i in range(1, 5) :
        calcMat[0][i-1] = sumColume(1, i)

    for i in range(1, n) :
        for j in range(1,5) :
            calcMat[i][j-1] =  max(allowPatternList(i-1, j)) + sumColume(i+1, j)


    return max(calcMat[n-1])

print pebble(5)
