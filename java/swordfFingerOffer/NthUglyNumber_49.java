package swordfFingerOffer;

/**
 * 面试题49. 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class NthUglyNumber_49 {

    public int nthUglyNumber(int n) {
        int p0 = 0, p1 = 0, p2 = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p0] * 2, Math.min(dp[p1] * 3, dp[p2] * 5));
            if (dp[i] == dp[p0] * 2) p0++;
            if (dp[i] == dp[p1] * 3) p1++;
            if (dp[i] == dp[p2] * 5) p2++;
            System.out.println(dp[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumber_49 nthUglyNumber_49 = new NthUglyNumber_49();
        System.out.println(nthUglyNumber_49.nthUglyNumber(16));
    }

}
