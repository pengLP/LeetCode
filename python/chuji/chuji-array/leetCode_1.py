"""
两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
"""
class Solution(object):
    def twoSum(self, nums, target):
        res = []
        for i in range(len(nums)):
            for j in range(1,len(nums)):
                if(target == nums[i] + nums[j] and i != j):
                    res.append(i)
                    res.append(j)
                    return res

if __name__ == '__main__':
    s = Solution()
    print(s.twoSum([2,5,5,11],10))