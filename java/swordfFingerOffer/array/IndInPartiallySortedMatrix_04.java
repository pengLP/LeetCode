package swordfFingerOffer.array;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class IndInPartiallySortedMatrix_04 {

    public boolean find(int matrix[][], int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }


    public static void main(String[] args) {
        IndInPartiallySortedMatrix_04 indInPartiallySortedMatrix_04 = new IndInPartiallySortedMatrix_04();
        int matrix[][] = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(indInPartiallySortedMatrix_04.find(matrix, 16));
    }
}
