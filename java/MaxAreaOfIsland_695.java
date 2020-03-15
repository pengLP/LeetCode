
/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid ,
 * 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * */
public class MaxAreaOfIsland_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0;i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res , getLandDfs(grid , i ,j));
                }
            }
        }
        return res;

    }

    public int getLandDfs(int[][] grid , int x ,int y) {
        int num = 1;
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 0)
            return 0;
        grid[x][y] = 0;
        num += getLandDfs(grid , x + 1 , y);
        num += getLandDfs(grid , x - 1 , y);
        num += getLandDfs(grid , x , y + 1);
        num += getLandDfs(grid , x , y - 1);
        return num;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_695 maxAreaOfIsland_695 = new MaxAreaOfIsland_695();
        System.out.println(maxAreaOfIsland_695.maxAreaOfIsland(new int[][]{{1,1,0,0,0},
                                                                            {1,1,0,0,0},
                                                                            {0,0,0,1,1},
                                                                            {0,0,0,1,1}}));
    }

}
