"""
存在重复
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
"""


class Solution(object):
    def containsDuplicate(self, nums):
        return len(nums) != len(set(nums))

if __name__ == '__main__':
    s = Solution()
    print(s.containsDuplicate([0]))
