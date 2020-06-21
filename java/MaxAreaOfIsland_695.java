import java.util.Map;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid ,
 * 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class MaxAreaOfIsland_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res, bfs(grid, i, j));
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j) {
        int num = 1;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        num += bfs(grid, i + 1, j);
        num += bfs(grid, i - 1, j);
        num += bfs(grid, i, j + 1);
        num += bfs(grid, i, j - 1);
        return num;
    }


    public static void main(String[] args) {

    }

}
