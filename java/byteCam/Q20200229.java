package byteCam;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：硬币组合
 * 假定我们有若干种不同面值的硬币，希望在给出要找的零的钱数以及可用的
 * 硬币面额d1,d2,...,dn及其数量之后，可以找出所需的最少的硬币个数的方案
 * */
public class Q20200229 {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp , max);
        dp[0] = 0;
        for (int i = 1;i <= amount;i++) {
            for (int j = 0;j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Q20200229 q20200229 = new Q20200229();
        System.out.println(q20200229.coinChange(new int[]{2} , 3));
    }


}
