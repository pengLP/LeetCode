package dp;

import java.util.Arrays;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int[] row : dp) System.out.println(Arrays.toString(row));

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePaths_62 uniquePaths_62 = new UniquePaths_62();
        System.out.println(uniquePaths_62.uniquePaths(1, 2));
    }
}
