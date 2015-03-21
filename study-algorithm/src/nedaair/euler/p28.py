__author__ = 'nedaair'

from math import sqrt


member = [1]

end      = 1
increase = 2



while True :

    for i in range(1, 5) :
           member.append(end + (i * increase))

           if i == 4 :
              end = end + (i * increase)
              increase += 2

    if sqrt(end) == 1001 :
        break

print sum(member)