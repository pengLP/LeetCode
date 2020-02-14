"""
两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集
"""


class Solution(object):
    def intersect(self, nums1, nums2):
        hash1 = {}
        hash2 = {}
        for i in nums1:
            if(not i in hash1):
                hash1[i] = 1
            else:
                hash1[i] += 1
        res = []
        for i in nums2:
            if(i in hash1 and hash1[i] != 0):
                res.append(i)
                hash1[i]-=1
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.intersect(nums1 = [1,2,2,1], nums2 = [2,2]))