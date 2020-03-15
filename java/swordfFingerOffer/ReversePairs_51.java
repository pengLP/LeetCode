package swordfFingerOffer;

/**
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * */
public class ReversePairs_51 {

    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0;i < nums.length-1; i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i] > nums[j])
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReversePairs_51 reversePairs_51 = new ReversePairs_51();
        System.out.println(reversePairs_51.reversePairs(new int[]{7,5,6,4}));
    }
}
