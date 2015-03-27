__author__ = 'nedaair'


material = [0, 1, 2, 3, 4]
lResult = []

def lexicographicPermutations(dv, l) :

    if len(l) == 0 :
        lResult.append(dv)
        return

    for i in (l) :
        k = l[:]
        k.remove(i)

        lexicographicPermutations(dv+str(i), k)

lexicographicPermutations("", material)


print len(lResult)
