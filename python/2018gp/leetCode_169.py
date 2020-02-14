"""
 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
"""
from collections import Counter
class Solution:
    def majorityElement(self, nums) -> int:
        count = Counter(nums)
        tmp = int(len(nums)/2)
        for i in nums:
            if count[i] > tmp:
                return i

if __name__ == '__main__':
    s = Solution()
    print(s.majorityElement([2]))