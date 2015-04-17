
#-*- coding: utf-8 -*-
__author__ = 'nedaair'

import math

def isPrime(x) :
    #print "isPrime", x
    if  x <= 1 :
        return False
    elif  x % 2 == 0 :
        return x==2 #짝수는 2만 소수이다
    else :
        sq = int(math.sqrt(x)) +1
        #이미 짝수는 제외시켰으므로, [3, sqrt(x)]범위에서 약수가 존재하는지 확인한다.

        for i in range(3, sq+1, 2) :
            if x % i == 0 :
                #약수가 존재한다면 소수가 아니다.
                return False

    #이때까지 약수가 발견되지 않았다면 소수이다.
    return True

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

def maxCommonYaksu(target1, target2) :
    return sorted(list(set(yaksu(target1)).intersection(set(yaksu(target2))))).pop()


def factorial(n) :
    if n == 0 or n == 1 : return 1
    else :
        sum = 1
        for i in range(1,n+1) :
            sum = sum * i

        return sum

def fibonacci(n) :

    if n == 0 :
        return 0
    elif n == 1 :
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)