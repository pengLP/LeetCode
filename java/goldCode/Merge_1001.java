package goldCode;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 */

public class Merge_1001 {


    public void merge1(int[] A, int m, int[] B, int n) {
        for (int i = 0, j = m; j < A.length; j++, i++) {
            A[j] = B[i];
        }
        Arrays.sort(A);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        while (n > 0) {
            A[n - 1] = B[n-- - 1];
        }

        for (Integer i : A) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Merge_1001 merge_1001 = new Merge_1001();
        merge_1001.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

}
