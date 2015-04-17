__author__ = 'nedaair'

from nedaair.util.smath import factorial

l = []
cacheFactorial = {}

for i in range(0, 10) :
    cacheFactorial[i] = factorial(i)


for i in range(10, 10000000) :

    if i == sum(cacheFactorial[int(j)] for j in str(i)) :

        l.append(i)

print sum(l)


#999999    -> 2177280
#9999999   -> 2540160








