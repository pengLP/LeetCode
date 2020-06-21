package swordfFingerOffer;


/**
 * 面试题47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValue_47 {

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int n = grid[0].length;
        int dp[] = new int[n];
        for (int[] value : grid) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
            for (int i = 0; i < n; i++) {
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
        return dp[n - 1];
    }


}
