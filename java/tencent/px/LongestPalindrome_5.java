package tencent.px;

import java.util.Arrays;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        int len = s.length() - 1;
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 1;i <= len; i++) {
            for (int j = 1;j <= len; j++) {
                if (s.charAt(i) == s.charAt(len - j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        int index = 0 , maxLen = -1;
        for (int i = 0 ;i <= len; i++) {
            for (int j = 0;j <= len; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    index = i;
                }
            }
        }
        return s.substring(index + 1 - maxLen, index + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        System.out.println(longestPalindrome_5.longestPalindrome("babad"));
    }
}
