__author__ = 'nedaair'

import re


p = re.compile('^((100+1+)|(01)+)+$')


def matchTest(target) :
    if p.match(target) :
        return 'YES'
    else :
        return 'NO'

def matchTest2(target) :

    if target == '' : return 'YES'

    if target.find('01') == 0 :
        return matchTest2(target[2:])
    else :
        if target.find('100') == 0 :
            if target[3:].find('10') != -1 :
                return matchTest2(target[3+target[3:].find('10')+1:])
            elif target[3:].find('1') != -1:
                return matchTest2(target[3+target[3:].find('1')+1:])
            else :
                return 'NO'
        else :
            return 'NO'




print matchTest('10010111')
print matchTest('011000100110001')
print matchTest('0110001011001')


print matchTest2('10010111')
print matchTest2('011000100110001')
print matchTest2('0110001011001')