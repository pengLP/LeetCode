package match.m186;

public class LeetCode_5393 {

    public int maxScore(int[] cardPoints, int k) {
        int res = 0 , n = cardPoints.length-1;
        for (int i = 0;i <= k; i++) {
            int sum = 0;
            for (int index = 0;index < i; index++) {
                sum += cardPoints[index];
                System.out.print(cardPoints[index] + " ");
            }
            for (int j = 0; j< k - i;j++) {
                sum+= cardPoints[n - j];
                System.out.print(cardPoints[n - j] +" ");
            }
            System.out.println();
            res = Math.max(sum,res);
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_5393 leetCode_5393 = new LeetCode_5393();
        System.out.println(leetCode_5393.maxScore(new int[]{1,2,3,4,5,6,1} , 3));
    }
}
