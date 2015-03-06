#-*- coding: utf-8 -*-
__author__ = 'nedaair'

from nedaair.util.smath import yaksu


def exceedNumbers() :


    def exceedNumber(target) :
        n = yaksu(target)

        n.remove(target)

        if sum(n) > target : return True


    return filter(exceedNumber, range(1, 28112))




if __name__ == "__main__":

    l = []


    exceedNumberList = exceedNumbers()


    for index, i in enumerate(exceedNumberList) :
        for j in exceedNumberList[index:] :
           if i + j <= 28113 :
            l.append(i + j)



    allNumber = set(range(1, 28124))
    exceedNumber = set(l)

    print sum(allNumber - exceedNumber)









