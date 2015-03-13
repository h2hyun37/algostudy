__author__ = 'nedaair'


unSort = [31, 8, 48, 73, 11, 3, 20, 29, 65, 15]

def quickSort(list, start, end) :

    if start >= end :
        return

    centerIndex = partition(list, start, end)


    quickSort(list, start, centerIndex-1)
    quickSort(list, centerIndex+1, end)




def partition(list, start, end) :

    i = start

    for idx, ii in enumerate(list[start: end+1], start=start) :
        if ii <= list[end] :
            temp = ii
            list[idx] = list[i]
            list[i] = temp
            i += 1

    return i-1


quickSort(unSort, 0, len(unSort)-1)

print unSort