__author__ = 'nedaair'


unSort = [31, 3, 65, 73, 8, 11, 20, 29, 48, 15]

def mergeSort(unSort, p, r) :

    if p < r :
        q = (p+r)/2
        mergeSort(unSort, p, q)
        mergeSort(unSort, q+1, r)
        merge(unSort, p, q, r)


def merge(unSort, p, q, r) :

    i = p
    j = q+1
    temp = []

    while i <= q and j <= r :
        if unSort[i] <= unSort[j] :

            temp.append(unSort[i])

            i += 1
        else :
            temp.append(unSort[j])

            j += 1

    while i <= q :
        temp.append(unSort[i])
        i += 1

    while j <= r :
        temp.append(unSort[j])
        j += 1

    unSort[p:r+1] = temp

mergeSort(unSort, 0, len(unSort)-1)



print unSort


