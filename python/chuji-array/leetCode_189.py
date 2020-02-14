"""
旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
"""
class Solution(object):
    def rotate(self, nums, k):
        j = k % len(nums)

        self.revers(nums,0,len(nums) - j-1)
        self.revers(nums, len(nums) - j, len(nums)-1)
        nums.reverse()
        print(nums)


    def revers(self,nums,start,end):
        tmp = end
        for i in range(start,int((end+start)/2)+1):
            t = nums[i]
            nums[i] = nums[tmp]
            nums[tmp] = t
            tmp -= 1

if __name__ == '__main__':

    s = Solution()
    s.rotate([1,2,3,4,5,6,7],3)