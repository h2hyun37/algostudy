__author__ = 'nedaair'


from nedaair.util.smath import isPrime

primeList = []
primeCopyList = []

def isCircular(prime) :

    prime = str(prime)

    isP = True

    for i in range(0, len(str(prime))) :

        if not isPrime(int(prime[i:] + prime[:i])) or int(prime[i:] + prime[:i]) not in primeList:
            isP = False
            break


    return isP


def makePrimeList() :
    for i in range(1, 1000001) :

        if isPrime(i) :
            primeList.append(i)




def cirularCheck():
    for i in primeList :

        if not isCircular(i) :
            #print i
            primeCopyList.remove(i)

makePrimeList()
primeCopyList = primeList[:]
cirularCheck()

print len(primeCopyList)












