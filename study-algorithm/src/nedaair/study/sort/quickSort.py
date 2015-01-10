__author__ = 'nedaair'



unSort = [31, 8, 48, 73, 11, 3, 20, 29, 65, 15]

def quickSort(unSort, p, r) :

    if p < r :
        q = partition(unSort, p, r)
        quickSort(unSort, p, q-1)
        quickSort(unSort, q+1, r)
    pass


def partition(unSort, p, r) :

    x = unSort[r]
    i = p -1
    for j in range(p, r) :
        if unSort[j] < x :
            i += 1

            temp = unSort[i]
            unSort[i] = unSort[j]
            unSort[j] = temp


    unSort[r] = unSort[i+1]
    unSort[i+1] = x

    return i+1



quickSort(unSort, 0, len(unSort)-1)


print unSort