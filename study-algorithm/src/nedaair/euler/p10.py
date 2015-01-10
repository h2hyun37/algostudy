
# to

def aristoSosu(target) :

    i = 2

    targetList = range(2,target+1)
    insuList   = range(2,target+1)
    multiple = set([])

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




print sum(aristoSosu(200000))