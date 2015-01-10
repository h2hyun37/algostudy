__author__ = 'nedaair'

unSort = [3, 31, 48, 73, 8, 11, 20, 29, 65, 15]



def buildHeap(unSort) :

    unSortLen = len(unSort)-1

    for i in reversed(range(len(unSort)/2)) :
        heapify(unSort, i, unSortLen)


def heapify(unSort, k, n) :

    left = 2*k+1
    right = 2*k+2

    if right <= n :
          if unSort[left] <  unSort[right] :
              smaller = left
          else :
              smaller = right
    elif left <=n :
        smaller = left
    else :
        return

    if unSort[smaller] < unSort[k] :
        temp = unSort[k]
        unSort[k] = unSort[smaller]
        unSort[smaller] =  temp

        heapify(unSort, smaller, n)




buildHeap(unSort)

for i in reversed(range(1, 10)) :
   temp = unSort[0]

   unSort[0] = unSort[i]
   unSort[i] = temp

   heapify(unSort, 0, i-1)


print unSort








