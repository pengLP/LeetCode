"""
实现 strStr()
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(needle == ""):
            return 0
        i = 0
        j = 0
        tmp = 0
        while(i<len(haystack)):
            if(haystack[i] == needle[j]):
                i+=1
                j+=1
            else:
                i = tmp
                tmp += 1
                j = 0
            if(j == len(needle)):
                return i-j
        return -1

if __name__ == '__main__':
    s = Solution()
    print(s.strStr(haystack = "mississippi", needle = "issipi"))