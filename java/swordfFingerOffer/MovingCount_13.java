package swordfFingerOffer;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 作者：CyC2018
 * 链接：https://www.nowcoder.com/discuss/198840?type=1
 * 来源：牛客网
 *
 * 题目:13. 机器人的运动范围
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 * */
public class MovingCount_13 {

    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    /*广度优先*/
/*    public int movingCount(int m, int n, int k) {
        int matrix[][] = new int[m][n];
        boolean visit[][] = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (queue.size() != 0) {
            int []x = queue.poll();
            System.out.println(x[0] + " , " + x[1] + " , " + check(x[0],x[1],visit,matrix,k));
            if (!check(x[0],x[1],visit,matrix,k))
                continue;
            visit[x[0]][x[1]] = true;
            count++;
            queue.add(new int[]{x[0]+1,x[1]});
            queue.add(new int[]{x[0],x[1]+1});
        }
        return count;
    }*/


    //深度优先
    public int movingCount(int m, int n, int k) {
        int matrix[][] = new int[m][n];
        boolean visit[][] = new boolean[m][n];
        return dfs(0,0,visit,matrix,k);
    }

    public int dfs(int x,int y,boolean visit[][],int [][]matrix,int k) {
        if (check(x,y,visit,matrix,k)) {
            visit[x][y] = true;
            return 1 + dfs(x + 1,y,visit,matrix,k) + dfs(x,y + 1,visit,matrix,k);
        }
        return 0;
    }

    public boolean check(int x,int y,boolean visit[][] ,int matrix[][] , int k) {
        if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && !visit[x][y] && (getSum(x)+getSum(y) <= k)) {
            return true;
        }
        return false;
    }

    public int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount_13 movingCount_13 = new MovingCount_13();
        System.out.println(movingCount_13.movingCount(1,2,1));
    }

}
