"""
只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
"""
class Solution(object):
    def singleNumber(self, nums):
        d = {}
        for x in nums:
            if not x in d:
                d[x] = 1
            else:
                d[x] = d[x] + 1
        for i in d:
            if(d[i]==1):
                return i

    def singleNumber1(self,nums):
        num = 0
        for i in nums:
            num = num ^ i
        return num

if __name__ == '__main__':
    s = Solution()
    print(s.singleNumber1([4,1,2,1,2]))
