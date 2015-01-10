

def squareOfSum(num) :

    sum = 0
    for i in range(1, num + 1) :
        sum += pow(i, 2)

    return sum

def sumOfsquare(num) :

    sum =  0

    for i in range(1, num + 1) :
        sum += i

    return pow(sum, 2)


num = 100
print sumOfsquare(num) - squareOfSum(num)
