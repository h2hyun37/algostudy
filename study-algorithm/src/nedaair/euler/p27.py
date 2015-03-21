#-*- coding: utf-8 -*-
__author__ = 'nedaair'


from  nedaair.util.smath import isPrime

maxN = 0 #  연속된 N 중에서가장큰  N
maxN_a = 0  #  가장큰  N 의 a
maxN_b = 0  #  가장큰  N 의 b

for a in range(-999, 1000) :
    for b in range(-999, 1000) :
        n = 0
        while 1 :
          if isPrime(pow(n, 2) + (a * n) + b) :
              n += 1
          else :
              if maxN < n - 1 :
                  maxN = n -1
                  maxN_a = a
                  maxN_b = b
              break

print maxN_a * maxN_b


