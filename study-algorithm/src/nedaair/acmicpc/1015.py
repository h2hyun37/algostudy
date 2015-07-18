__author__ = 'nedaair'


initArray = [2, 3, 1]
#initArray = [3, 3, 4, 2]
mapArray = {}

def initMapArray():

    copyArray = initArray[:]

    copyArray.sort()

    for index, i in enumerate(copyArray) :
        if i in mapArray :
            mapArray[i].append(index)
        else :
            mapArray[i] = [index]


def printSequense():

    for i in initArray :
        print mapArray[i].pop(0)



if __name__ == '__main__':

    initMapArray()
    printSequense()



