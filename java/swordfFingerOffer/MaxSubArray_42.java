package swordfFingerOffer;

public class MaxSubArray_42 {

    public int maxSubArray(int[] nums) {
        int maxTmp = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length; i++) {
            if (maxTmp > 0){
                maxTmp += nums[i];
            }else {
                maxTmp = nums[i];
            }
            maxSum = Math.max(maxTmp , maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray_42 maxSubArray_42 = new MaxSubArray_42();
        System.out.println(maxSubArray_42.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
