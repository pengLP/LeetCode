"""
最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
"""
class Solution:
    def longestCommonPrefix(self, strs) -> str:
        res = ""
        for i in zip(*strs):
            if(len(set(i)) == 1):
                res+= i[0]
            else:
                break
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.longestCommonPrefix(["flower","flow","flight"]))
