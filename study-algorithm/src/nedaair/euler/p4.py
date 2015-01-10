
def maxPalindrome(digit):
      limitNum = pow(10, digit) # digit 2 =  100,   3 =  1000

      palindromeSet = set([])

      for i in range(1, limitNum) :
          for j in range(1, limitNum) :

              multiply = i * j

              if len(str(multiply)) > 2 and str(multiply) == str(multiply)[::-1] :
                  palindromeSet.add(multiply)

      palindromeList = list(palindromeSet)

      palindromeList.sort()

      return  palindromeList.pop()








print maxPalindrome(3)