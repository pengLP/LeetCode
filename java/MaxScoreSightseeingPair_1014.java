
/**
 * 1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * */
public class MaxScoreSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int maxScore = 0 , mx = 0;
        for (int i = 0;i < A.length; i++) {
            maxScore = Math.max(maxScore , A[i] - i + mx);
            mx = Math.max(A[i] - i , mx);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        MaxScoreSightseeingPair_1014 maxScoreSightseeingPair_1014 = new MaxScoreSightseeingPair_1014();
        System.out.println(maxScoreSightseeingPair_1014.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
