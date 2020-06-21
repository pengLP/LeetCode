package dp;

import java.util.Arrays;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        char cs[] = s.toCharArray();
        int j = -1;
        for (int i = 0; i < cs.length; i++) {
            j = t.indexOf(cs[i], j + 1);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s == null || t == null || s.length() > t.length())
            return false;
        int sLen = s.length(), tLen = t.length();
        if (sLen == 0)
            return true;
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        for (int j = 0; j <= tLen; j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        IsSubsequence_392 subsequence_392 = new IsSubsequence_392();
        System.out.println(subsequence_392.isSubsequence1("axc", "ahdgdc"));
    }
}
