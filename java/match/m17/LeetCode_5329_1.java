package match.m17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 方阵中战斗力最弱的 K 行 显示英文描述
 * 用户通过次数271
 * 用户尝试次数295
 * 通过次数271
 * 提交次数324
 * 题目难度Easy
 * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
 *
 * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * */
public class LeetCode_5329_1 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int res[] = new int[k];
        int num[][] = new int[mat.length][2];
        for (int i = 0;i < mat.length; i++) {
            for(int j = 0;j < mat[i].length; j++) {
                if(mat[i][j] == 1){
                    num[i][0]++;
                }
            }
        }

        for (int i = 0;i < num.length; i++) {
            num[i][1] = i;
        }
        sort(num , new int[]{0,1});
        for (int i = 0;i < k; i++) {
            res[i]= num[i][1];
        }

        return res;
    }

    public static void sort(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] > two[k]) {
                        return 1;
                    } else if (one[k] < two[k]) {
                        return -1;
                    } else {
                        continue;  //如果按一条件比较结果相等，就使用第二个条件进行比较。
                    }
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        LeetCode_5329_1 s = new LeetCode_5329_1();
        s.kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}},3);
    }
}
