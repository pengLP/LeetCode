"""
整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
"""
class Solution:
    def reverse(self, x: int) -> int:
        while(x != 0):
            print(x)
            x//=10
if __name__ == '__main__':
    s = Solution()
    s.reverse(-123)