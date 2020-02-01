"""
报数
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
"""

class Solution:
    def cut(self,s):
        p = 0
        q = 1
        res = ""
        while(q < len(s)):
            if(s[q] == s[p]):
                q+=1
            else:
                res += str(q-p)+s[p]
                p = q
                q+=1
        res += str(q - p) + s[p]
        return res
    def countAndSay(self, n: int) -> str:
        if(n == 1):
            return "1"
        if(n == 2) :
            return "11"
        res = self.cut("11")
        for i in range(3,n):
            res = self.cut(res)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.countAndSay(4))