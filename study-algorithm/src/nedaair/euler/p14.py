

dP = {1:1}              #dynamic programming

def collatz(arg) :

    target = arg

    i = 0
    while 1 :
        if target in dP :
            dP[arg] = i
            break

        if target % 2 == 0 :
            i = i+1
            target = target / 2
        else :
            i = i+1
            target = 3 * target + 1

    return i + dP[target]


maxProcessCnt = 0
collatzNum = 0

for i in xrange(1, 1000001) :
    processCnt =  collatz(i)


    if processCnt > maxProcessCnt :
        maxProcessCnt =  processCnt
        collatzNum    = i


print   collatzNum

