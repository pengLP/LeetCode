import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class MinIncrementForUnique_945 {

    public int minIncrementForUnique(int[] A) {

        if (A == null || A.length == 0)
            return 0;
        Arrays.sort(A);
        int ans = 0;
        int curr = A[0];
        for (int i = 1; i < A.length; i++) {
            while (A[i] <= curr) {
                A[i]++;
                ans++;
            }
            curr = A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MinIncrementForUnique_945 minIncrementForUnique_945 = new MinIncrementForUnique_945();
        System.out.println(minIncrementForUnique_945.minIncrementForUnique(new int[]{1, 2, 2}));
    }
}
