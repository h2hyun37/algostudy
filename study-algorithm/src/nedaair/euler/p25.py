__author__ = 'nedaair'


dp = {}


def fibonacci(n) :

    if n in dp : return dp[n]

    if n == 0 :
        dp[0] = 0
        return 0
    elif n == 1 :
        dp[1] = 1
        return 1
    else:

        dp[n] = fibonacci(n-1) + fibonacci(n-2)

        return dp[n]


def seek1000Digit() :

    i = 1

    while 1 :

         if len(str(fibonacci(i))) == 1000 :
             return i
             break

         i += 1



print seek1000Digit()
