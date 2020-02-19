public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0 , col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{{}}, 1));
    }
}
