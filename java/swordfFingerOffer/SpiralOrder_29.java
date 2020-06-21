package swordfFingerOffer;

import java.util.*;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class SpiralOrder_29 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int endX = matrix.length - 1, endY = matrix[0].length - 1;
        int startX = 0, startY = 0, index = 0;
        while (startX <= endX && startY <= endY) {

            for (int j = startY; j <= endY; j++) {
                res.add(matrix[startX][j]);
            }
            for (int i = startX + 1; i <= endX; i++) {
                res.add(matrix[i][endY]);
            }
            if (startX < endX && startY < endY) {
                for (int j = endY - 1; j >= startY; j--) {
                    res.add(matrix[endX][j]);
                }
                for (int i = endX - 1; i >= startX + 1; i--) {
                    res.add(matrix[i][startY]);
                }
            }
            endX--;
            endY--;
            startX++;
            startY++;
        }
        for (Integer i : res) {
            System.out.println(i);
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder_29 spiralOrder_29 = new SpiralOrder_29();
        spiralOrder_29.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}});
    }

}
