
/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs1(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;

        int dp[] = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i <= cost.length; i++) {
            if (i != cost.length)
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            else
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int dp0 = 0;
        int dp1 = Math.min(cost[0], cost[1]);
        int dp2 = 0;
        for (int i = 2; i < cost.length; i++) {
            dp2 = Math.min(dp1 + cost[i], dp0 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;

        }
        return dp2;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs_746 minCostClimbingStairs_746 = new MinCostClimbingStairs_746();
        System.out.println(minCostClimbingStairs_746.minCostClimbingStairs(new int[]{0, 1, 1, 0}));
    }
}
