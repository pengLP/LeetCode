import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */

class Node1 {
    int x;
    int y;

    Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class OrangesRotting_994 {


    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        Queue<Node1> queue = new LinkedList<>();
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Node1(i, j));
                }
            }
        }
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node1 node = queue.poll();
                int x = node.x;
                int y = node.y;
                if (x + 1 < row && grid[x + 1][y] == 1) {
                    queue.add(new Node1(x + 1, y));
                    count--;
                    grid[x + 1][y] = 2;
                }
                if (y + 1 < col && grid[x][y + 1] == 1) {
                    queue.add(new Node1(x, y + 1));
                    count--;
                    grid[x][y + 1] = 2;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.add(new Node1(x, y - 1));
                    count--;
                    grid[x][y - 1] = 2;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.add(new Node1(x - 1, y));
                    count--;
                    grid[x - 1][y] = 2;
                }
            }
        }
        return count > 0 ? -1 : round;
    }

}
