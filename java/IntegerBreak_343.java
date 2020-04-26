import java.util.Arrays;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * */
public class IntegerBreak_343 {

    public int integerBreak(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3;i <= n;i ++) {
            for (int j = 1;j <= i/2; j++) {
                dp[i] = Math.max(dp[i] , Math.max((i - j) * j , j * dp[i - j]));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak_343 integerBreak_343 = new IntegerBreak_343();
        System.out.println(integerBreak_343.integerBreak(10));
    }

}
