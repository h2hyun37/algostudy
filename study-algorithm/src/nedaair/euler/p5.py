
def soinsu(target) :

    num =  target
    i = 2
    numSet = set([2])

    while i <= num:

        checkNum = 1

        for j in list(numSet) :
            if i % j == 0 :
                checkNum = 0
                break

        if checkNum :
            numSet.add(i)

        i += 1

    return list(numSet)

def soinsuOfMulti(soinsuList) :

    sum = 1
    for i in soinsuList :
           sum *= i

    return sum



def divideAllNum(startNum, checkRange) :

    num =  startNum
    while 1 :

        check = 0
        for i in range(1, checkRange+1) :
            if num % i == 0 :
                check += 1

        if check == checkRange :
            break
        else :
            num += startNum


    return num





checkRange = 20
startNum = soinsuOfMulti(soinsu(checkRange))

print divideAllNum(startNum, checkRange)
