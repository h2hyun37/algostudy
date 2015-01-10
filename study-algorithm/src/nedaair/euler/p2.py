

def fibonacchi(a, b, sum=0):

    if(b > 4000000) : return sum

    if(b % 2 == 0) :
        sum += b
    return fibonacchi(b, a+b, sum)

print fibonacchi(1, 2)
