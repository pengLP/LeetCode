"""
从排序数组中删除重复项
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
"""
class Solution:
    def removeDuplicates(self, nums) -> int:
        res = 0
        for i in range(len(nums)):
            if(nums[res] != nums[i]):
                res+=1
                nums[res] = nums[i]
        print(nums)
        return res+1


if __name__ == '__main__':
    s = Solution()
    print(s.removeDuplicates([0,0,1,1,1,2,2,3,3,4]))