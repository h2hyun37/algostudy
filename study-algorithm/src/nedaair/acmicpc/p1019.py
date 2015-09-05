__author__ = 'nedaair'


num = [0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0]


for i in range(1, 12) :
    for j in str(i) :
        num[int(j)] = num[int(j)] + 1

print num
