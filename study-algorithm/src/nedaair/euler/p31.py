__author__ = 'nedaair'


numberOfCase = {}

money = [2, 5, 10, 20, 50, 100, 200]

for i in range(0, 201) :
    numberOfCase[i] = 1

for i in money :
    for j in range(i, 201) :
        numberOfCase[j] = int(numberOfCase[j]) + int(numberOfCase[j - i])


print numberOfCase[200]


