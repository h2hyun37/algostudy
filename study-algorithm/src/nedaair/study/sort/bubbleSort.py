__author__ = 'nedaair'


unSort = [3, 31, 48, 73, 8, 11, 20, 29, 65, 15]




def bubbleSort(unSort) :

    temp = 0
    sorted = 1

    for idx, i in reversed(list(enumerate(unSort))) :

        for idx1, j in enumerate(unSort[:idx]) :

            if unSort[idx1] > unSort[idx1+1] :
                    temp = unSort[idx1+1]
                    unSort[idx1+1] = unSort[idx1]
                    unSort[idx1] = temp
                    sorted = 0


        if sorted == 1 : break

    print unSort



bubbleSort(unSort)
