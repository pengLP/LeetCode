package dp;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class MinDistance_72 {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++)
            dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j <= m; j++)
            dp[0][j] = dp[0][j - 1] + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1] - 1, dp[i][j - 1]));
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        for (int[] row : dp) System.out.println(Arrays.toString(row));
        return dp[n][m];
    }

    public static void main(String[] args) {
        MinDistance_72 minDistance_72 = new MinDistance_72();
        System.out.println(minDistance_72.minDistance("horse", "ros"));
    }

}
