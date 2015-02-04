__author__ = 'nedaair'


unSortedList = [31, 8, 48, 73, 11, 3, 20, 29, 65, 15]


def quickSort(l, start, end) :

    if start >= end :
        return

    r = partition(unSortedList, start, end)

    quickSort(l, start, r-1)
    quickSort(l, r+1, end)


def partition(l, start, end) :

    i = start

    for idx, ii in enumerate(l[start: end+1], start=start) :
        if ii <= l[end] :
            temp = ii
            l[idx] = l[i]
            l[i] = temp
            i += 1

    return i-1


quickSort(unSortedList, 0, len(unSortedList)-1)


print unSortedList

