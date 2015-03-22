__author__ = 'P052400'



def getCoordinate(point , distance) :

    l1, l2, l34 = set(), set(), set()

    # part 1 compute
    for i in range(0, distance+1) :
        l1.add(tuple([point[0]+i, point[1] + distance - i]))

    # part 2 compute
    for i in l1 :
        l2.add(tuple([i[0], point[1] - abs(abs(distance) - abs(i[0]))]))

    # part 3,4 compute
    for i in l1 | l2 :
        l34.add(tuple([point[0] - abs(abs(distance) - abs(i[1])),i[1]]))

    return l1 | l2 | l34 #union


print len(getCoordinate([0, 0], 13) & getCoordinate([40, 0], 37))
print len(getCoordinate([0, 0], 3) & getCoordinate([0, 7], 4))
print len(getCoordinate([1, 1], 1) & getCoordinate([1, 1], 5))
