__author__ = 'nedaair'


start = 10

l = []

def get5thPower(num) :
    sum = 0

    for i in str(num) :
        sum += pow(int(i),5)

    return sum


while True :

    if start == get5thPower(start) : l.append(start)

    if start == get5thPower(99999) : break

    start += 1

print sum(l)