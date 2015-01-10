import math
import datetime

def yaksu(samkasu) :


    result  = []


    for i in range(1, int(math.sqrt(samkasu))) :

        if samkasu % i == 0 :
            result.append(i)
            result.append(samkasu / i)

    if len(result) >= 500 :
        return samkasu
    else :
        return ""

def samgaksu() :

    i = 1
    sum = 0
    while i :

        sum += i

        if yaksu(sum) != "" : break


        i += 1


    return sum

a = datetime.datetime.now()

print samgaksu()

b = datetime.datetime.now()

c = b - a

print c.seconds
