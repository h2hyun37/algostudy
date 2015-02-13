__author__ = 'nedaair'


unsortList = [3, 31, 48, 73, 8, 11, 20, 29, 65, 15]




def bubbleSort() :

    index = 1

    while 1 :

        indexf = 0
        for j in unsortList :
            if j > unsortList[indexf+1] :

                temp = unsortList[indexf+1]
                unsortList[indexf+1] = j
                unsortList[indexf] = temp
            indexf = indexf +  1

            if indexf == len(unsortList)-index : break

        index = index + 1

        if index == 10 :
            break


bubbleSort()

print unsortList