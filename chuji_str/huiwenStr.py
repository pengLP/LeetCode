# -*- coding: utf-8 -*
"""
验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。
"""



class Solution:
    def isPalindrome(self, s: str) -> bool:
        matchObj = re.sub("\W*|\D*","",s).lower()
        for i in range(int(len(matchObj)/2)):
            if(matchObj[i] != matchObj[len(matchObj)-i-1]):
                print(matchObj[i])
                return False
        return True





if __name__ == '__main__':
    s = Solution()
    print(s.isPalindrome("A man, a plan, a canal: Panama"))