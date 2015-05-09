__author__ = 'nedaair'

from nedaair.util.smath import isPrime


index = 10

strangePrimeList = []


while True :

    lenIndex = len(str(index))

    isAllPrime = True

    for i in range(0, lenIndex):
         if (not isPrime(int(str(index)[0:i+1]))) or (not isPrime(int(str(index)[lenIndex-i-1:]))):
            isAllPrime = False
            break

    if isAllPrime :
        strangePrimeList.append(index)

    if len(strangePrimeList) == 11 :
        break

    index = index + 1

print sum(strangePrimeList)
