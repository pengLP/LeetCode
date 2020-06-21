package match.m180;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_5365 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isLucky(i, j, matrix)) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;


    }

    private boolean isLucky(int x, int y, int[][] matrix) {
        int num = matrix[x][y];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] > matrix[x][y])
                return false;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[x][j] < matrix[x][y])
                return false;
        }
        return true;
    }


}
