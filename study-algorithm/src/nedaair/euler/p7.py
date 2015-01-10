def indexOfsosu(index) :

    i = 2
    numSet = set([2])

    while 1:

        checkNum = 1

        for j in list(numSet) :
            if i % j == 0 :
                checkNum = 0
                break

        if checkNum :
            numSet.add(i)

        i += 1

        if len(numSet) == index :
            break;


    numSetList = list(numSet)

    numSetList.sort()

    return numSetList.pop()


print indexOfsosu(10001)

