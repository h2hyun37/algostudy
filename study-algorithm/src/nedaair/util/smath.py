__author__ = 'nedaair'

import math

def sosu(target) :

    targetList = range(2,target+1)
    insuList   = range(2,target+1)

    for i in  targetList:
        k = 0
        if i in insuList :
            for j in insuList :

                if j % i == 0:
                    k += 1
                    insuList.remove(j)
            if k :
                insuList.append(i)


    return  insuList

def yaksu(target) :
    result  = []


    for i in range(1, int(math.sqrt(target))+1) :

        if target == 1 :
            result.append(1)
        elif target % i == 0:
            result.append(i)
            if target / i != i :
                result.append(target / i)

    result.sort()

    return result


def factorial(n) :
    if n == 0 or n == 1 : return 1
    else :
        sum = 1
        for i in range(1,n+1) :
            sum = sum * i

        return sum