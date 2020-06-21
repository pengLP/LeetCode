import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，
 * 上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
public class MaxDistance_1162 {

    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }
        if (queue.size() == (m * n) || queue.size() == 0)
            return -1;
        int ans = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur[] = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1)
                        continue;
                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            ans++;
        }
        return ans == -1 ? 0 : ans;
    }


    public int maxDistance1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : 400;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                if (i - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                    continue;
                if (i + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                if (j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0)
                    res = Math.max(res, dp[i][j]);
            }
        }
        return res == 400 ? -1 : res;
    }
}
