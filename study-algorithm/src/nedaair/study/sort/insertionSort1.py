__author__ = 'P052400'


randomNum = [12, 70, 30, 20, 55, 25, 40, 50]


def sort() :

    for idx  , i  in enumerate(randomNum[1:], start=1) :

        insertionLoc = -1
        for jdx, j in reversed(list(enumerate(randomNum[:idx]))) :
            if j > i :
                insertionLoc = jdx
                randomNum[jdx+1] = j
        randomNum[insertionLoc] = i

sort ()

print randomNum


