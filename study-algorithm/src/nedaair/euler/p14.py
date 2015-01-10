


def collatz(target) :

    i = 1

    while 1 :
        i+= 1
        if target % 2 == 0 :
            target = target / 2
        else :
            target = 3 * target + 1


        if target == 1 :
            break

    return i



maxProcessCnt = 0
collatzNum = 0

for i in xrange(2, 1000001) :
    processCnt =  collatz(i)


    if processCnt > maxProcessCnt :
        maxProcessCnt =  processCnt
        collatzNum    = i


print   collatzNum

