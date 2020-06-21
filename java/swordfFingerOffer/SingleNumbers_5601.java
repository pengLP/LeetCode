package swordfFingerOffer;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class SingleNumbers_5601 {

    public int[] singleNumbers(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        int onePosition = x & -x;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & onePosition) == onePosition) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }
        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        SingleNumbers_5601 singleNumbers_5601 = new SingleNumbers_5601();
        System.out.println(singleNumbers_5601.singleNumbers(new int[]{4, 4, 6, 1}));
    }
}
