class Solution:
    def maxSubArray(self, nums) -> int:
        max = nums[0]
        n = nums[0]
        for i in range(1,len(nums)):
            if(n > 0):
                n += nums[i]
            else:
                n = nums[i]
            if(max < n):
                max = n
        return max
if __name__ == '__main__':
    s = Solution()
    print(s.maxSubArray([1]))