__author__ = 'P052400'


count0 = 0
count1 = 0

def fibonacci(n) :

    global count0
    global count1



    if n == 0 :
        count0 =  count0 + 1
        return 0
    elif n == 1 :
        count1 =  count1 + 1
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)


def printFibonacci(n) :

    global count0
    global count1

    fibonacci(n)

    print count0, count1

    count0 = 0
    count1 = 0




printFibonacci(0)
printFibonacci(1)
printFibonacci(3)


