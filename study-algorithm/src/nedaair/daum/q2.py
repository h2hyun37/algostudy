#-*- coding: utf-8 -*-
__author__ = 'nedaair'


target  = ['?', '11?', '11', '22', '12', '1?2', '??1', '1??1', '1???1', '1???2']
result = []



for targetItem in target :

   evalResult = 'right word'

   print targetItem

   if '11' in targetItem or '22' in targetItem :
       evalResult = 'wrong word'
   else:
       if '?' in targetItem :
            if  len(targetItem) == 1:
                evalResult = 'right word'
            elif targetItem.index('?') == 0 or  targetItem.rindex('?') == len(targetItem)-1 :
                evalResult = 'unknown word'
            else:
                if targetItem[targetItem.index('?') - 1] == targetItem[targetItem.rindex('?') + 1] :
                    if targetItem.count('?') % 2 == 0 :
                         evalResult = 'wrong word'
                    else:
                         evalResult = 'unknown word'
                elif  targetItem[targetItem.index('?') - 1] != targetItem[targetItem.rindex('?') + 1] :
                    if targetItem.count('?') % 2 == 0 :
                        evalResult = 'unknown word'
                    else:
                        evalResult = 'wrong word'

   result.append(evalResult)


