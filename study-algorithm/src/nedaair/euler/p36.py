__author__ = 'nedaair'



def bin(target, left) :

    if target < 2 :
        return str(target) + left

    return bin(target/2, str(target % 2) + left)



def symetry(target) :

    if str(target) != str(target)[::-1] :return False


    binaryTarget = bin(target, "")


    if  binaryTarget == binaryTarget[::-1]:
        return True
    else :
        return False




print sum(filter(symetry,range(1, 1000001)))


