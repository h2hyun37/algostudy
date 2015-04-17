__author__ = 'nedaair'

from nedaair.util.smath import maxCommonYaksu

numeratorList   = []
denominatorList = []


for numerator in range(11, 100) :
    for denominator in range(11, 100) :

        if numerator >= denominator :
            continue
        elif numerator % 10 == 0 and denominator % 10 == 0 :
            continue

        val = numerator / (denominator * 1.0)


        try:


            if str(numerator)[0] == str(denominator)[0] and  int(str(numerator)[1]) / ((int(str(denominator)[1]) * 1.0)) == val:
                numeratorList.append(numerator)
                denominatorList.append(denominator)
            elif str(numerator)[0] == str(denominator)[1]  and int(str(numerator)[1]) / ((int(str(denominator)[0]) * 1.0)) == val:
                numeratorList.append(numerator)
                denominatorList.append(denominator)
            elif str(numerator)[1] == str(denominator)[0]  and  int(str(numerator)[0]) / ((int(str(denominator)[1]) * 1.0)) == val:
                numeratorList.append(numerator)
                denominatorList.append(denominator)
            elif str(numerator)[1] == str(denominator)[1]  and  int(str(numerator)[0]) / ((int(str(denominator)[0]) * 1.0)) == val:
                numeratorList.append(numerator)
                denominatorList.append(denominator)
        except ZeroDivisionError as e:
            continue




print  reduce(lambda x, y : x * y  , denominatorList) / \
       maxCommonYaksu(reduce(lambda x, y : x * y  , numeratorList), reduce(lambda x, y : x * y  , denominatorList))
