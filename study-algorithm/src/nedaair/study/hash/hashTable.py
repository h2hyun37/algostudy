__author__ = 'nedaair'


inSertList = [10, 20, 30, 40 ,33,  46, 50, 60]

hashTable = []

def hashFunction(x) :

    return x % 13


def hashInsert(location, x) :



    try :
        print hashTable[location]
    except IndexError :
        print -1






def hashSearch(x) :
    pass

def hashDelete(x) :
    pass



for i in inSertList :

    hashInsert(hashFunction(i), i)


print hashSearch(46)

hashDelete(46)

print hashSearch(46)










