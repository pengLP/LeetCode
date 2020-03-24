package dp;

import java.util.Arrays;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        String max = "";
        boolean dp[][] = new boolean[n + 1][n + 1];
        for (int j = 0;j <= n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j || i + 1 == j){
                    dp[i][j] = true;
                }else if (s.charAt(i) == s.charAt(j - 1) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
                if (i != j && dp[i][j] && max.length() <= j - i)
                    max = s.substring(i , j);
            }
            for (boolean[] row:dp)   System.out.println(Arrays.toString(row));
            System.out.println("=================");
        }


        return max;
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        System.out.println(longestPalindrome_5.longestPalindrome("babadsdfasfxcvcxdfasdfafasfsvcdsfsadf"));
    }

}
