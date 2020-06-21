public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    maxval = Math.max(maxval, dp[j]);
            }
            dp[i] = maxval + 1;
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS_300 lengthOfLIS_300 = new LengthOfLIS_300();
        System.out.println("===>" + lengthOfLIS_300.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
