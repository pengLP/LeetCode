"""
打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
"""
class Solution:
    def rob(self, nums) -> int:
        if(len(nums) == 0):
            return 0
        res = []
        res.append(0)
        res.append(nums[0])
        for index in range(2,len(nums)+1):
            res.append(max(res[index-1],res[index-2]+nums[index-1]))
        return res[len(nums)]
if __name__ == '__main__':
    s = Solution()
    s.rob([1,2,3,1])


