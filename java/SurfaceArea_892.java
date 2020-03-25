
/**
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 * */
public class SurfaceArea_892 {

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int ans = 0;
        int N = grid.length;
        for (int i = 0;i < N; i++) {
            for (int j = 0;j < N; j++) {
                if (grid[i][j] > 0){
                    ans+=2;
                    for (int k = 0;k < 4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];
                        ans += Math.max(grid[i][j] - nv , 0);
                    }
                }
            }
        }
        return ans;
    }


}
