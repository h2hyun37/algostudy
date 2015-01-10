__author__ = 'nedaair'


unSort = [8, 31, 48, 73, 3, 65, 20, 29, 11, 15]


def selectionSort(unSort) :

    lenth   = len(unSort)
    temp  = 0
    tempIndex = 0

    for idx, i in reversed(list(enumerate(unSort))) :

       tempIndex = theLargest(unSort, idx)

       temp = unSort[tempIndex]
       unSort[tempIndex] = unSort[idx]
       unSort[idx] = temp

    print  unSort


def theLargest(unSort, last) :

    largest = 0

    for idx, i in enumerate(unSort[1:last+1]) :
        if i > unSort[largest] : largest = idx + 1


    return largest



selectionSort(unSort)