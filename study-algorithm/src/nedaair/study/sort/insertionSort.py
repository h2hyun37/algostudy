__author__ = 'nedaair'



unSort = [3, 31, 48, 73, 8, 11, 20, 29, 65, 15]


def insertionSort(unSort) :


    for idx, i in enumerate(unSort[1:], start=1) :

        loc     = idx -1
        newItem = i

        while loc >= 0 and newItem < unSort[loc] :
            unSort[loc+1] = unSort[loc]
            loc -= 1

        unSort[loc+1] = newItem

    print unSort

insertionSort(unSort)

