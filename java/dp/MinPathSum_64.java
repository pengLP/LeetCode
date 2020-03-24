package dp;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * */
public class MinPathSum_64 {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length , col = grid[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++)
            dp[i][0] += grid[i - 1][0];
        for (int j = 1;j < col; j++)
            dp[0][j] += grid[0][j];
        for (int i = 1;i < row; i++) {
            for (int j = 1;j < col; j++) {
                dp[i][j] += (Math.min(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j]);
            }
        }
        for (int[] r:dp) System.out.println(Arrays.toString(r));

        return dp[row - 1][col - 1];
    }

}
