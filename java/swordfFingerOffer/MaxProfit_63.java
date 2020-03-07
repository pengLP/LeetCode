package swordfFingerOffer;

public class MaxProfit_63 {

    public int maxProfit(int[] prices) {
        int minCur = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0;i < prices.length; i++) {
            minCur = Math.min(minCur , prices[i]);
            sum = Math.max(sum , prices[i] - minCur);
        }
        return sum;
    }
}
