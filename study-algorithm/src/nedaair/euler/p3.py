

num =  600851475143

i = 2

numSet = set([])

while i <= num:

    if num % i == 0 :
        numSet.add(i)
        num = num / i
        i = 2
    else:
        i += 1


soinsuList = list(numSet)

soinsuList.sort()

print soinsuList.pop()
