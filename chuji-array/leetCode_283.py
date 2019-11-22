"""
移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
"""
class Solution(object):
    def moveZeroes(self, nums):
        high = len(nums)-1
        while(high >= 0):
            if(nums[high] == 0):
                for i in range(high+1, len(nums)):
                    nums[i-1] = nums[i]
                nums[len(nums)-1] = 0
            high-=1
        return nums
if __name__ == '__main__':
    s = Solution()
    print(s.moveZeroes([0,1,0,3,12]))