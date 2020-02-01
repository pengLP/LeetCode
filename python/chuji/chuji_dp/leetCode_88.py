
"""
爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
a(1) = 1
a(2) = a(1)+1 , 2

"""
class Solution:
    def climbStairs(self, n: int) -> int:
        climb = dict()
        climb[0],climb[1] =1,1
        for i in range(2,n+1):
            climb[i] = climb[i-1]+climb[i-2]
        return climb[n]
if __name__ == '__main__':
    s = Solution()
    print(s.climbStairs(35))