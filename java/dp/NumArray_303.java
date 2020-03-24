package dp;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * */
public class NumArray_303 {

    private int dp[];


    public NumArray_303(int[] nums) {
        this.dp = new int[nums.length + 1];
        for (int i = 0;i < nums.length; i++) {
            dp[i + 1] += dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }

    public static void main(String[] args) {
        NumArray_303 numArray_303 = new NumArray_303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray_303.sumRange(0 , 2));
    }

}
