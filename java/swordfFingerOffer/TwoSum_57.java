package swordfFingerOffer;

/**
 * 面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * */
public class TwoSum_57 {

    public int[] twoSum(int[] nums, int target) {

        int left = 0 , right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left] + nums[right];
            if (tmp == target) {
                return new int[]{nums[left] , nums[right]};
            }
            if (tmp > target) {
                right--;
            }
            if (tmp < target) {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum_57 twoSum_57 = new TwoSum_57();
        int res[] = twoSum_57.twoSum(new int[]{1,2,4,7,11,15} , 15);
        for (Integer i:res) {
            System.out.println(i);
        }
    }
}
