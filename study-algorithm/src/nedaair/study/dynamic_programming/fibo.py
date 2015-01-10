__author__ = 'nedaair'


def fibonachi(n) :

    fibo = {}

    fibo[1] = 1
    fibo[2] = 1

    for i in range(3, n+1) :
        fibo[i] = fibonachi(i -1) + fibonachi(i -2)


    return fibo[n]


print fibonachi(10)








