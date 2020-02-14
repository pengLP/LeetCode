"""
加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。
"""
import sys
class Solution(object):
    def plusOne(self, digits):
        digits.reverse()
        digits[0] += 1
        i = 0
        while(digits[i]>=10 and i < len(digits)-1):
            digits[i] %= 10
            i+=1
            digits[i]+=1
        if(digits[len(digits)-1] % 10 == 0):
            digits[len(digits) -1] %= 10
            digits.append(1)
        digits.reverse()
        return digits

    def plusOne1(self , digits):
        return list(map(int, list(str(int(''.join(map(str, digits))) + 1))))
    
if __name__ == '__main__':
    s = Solution()
    print(s.plusOne1([9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9]))