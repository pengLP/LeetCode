package goldCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * */
public class Rotate_0107 {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        for (int i = 0;i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0;i < matrix.length; i++) {
            for (int j = 0;j < matrix[i].length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length- j -1 ];
                matrix[i][matrix[i].length - j - 1] = tmp;
            }
        }
        for (int[] row:matrix) System.out.println(Arrays.toString(row));

    }

}
