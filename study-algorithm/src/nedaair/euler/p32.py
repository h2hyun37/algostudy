__author__ = 'nedaair'

setC = set([])


for i in xrange(1, 10000) :
    for j in xrange(1, int("9" * (5- len(str(i)))) + 1) :

        if len(str(i)) + len(str(j)) + len(str(i * j)) > 9 :
            break
        elif len(str(i)) + len(str(j)) + len(str(i * j)) == 9 :
            if  ''.join(sorted(str(i) + str(j) + str(i*j))) == "123456789" :
                setC.add(i * j)

print sum(setC)

