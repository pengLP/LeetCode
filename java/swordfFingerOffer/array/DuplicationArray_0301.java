package swordfFingerOffer.array;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class DuplicationArray_0301 {

    public boolean duplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    return true;
                }
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicationArray_0301 three = new DuplicationArray_0301();
        int nums[] = new int[]{2, 1, 3, 0, 4};
        System.out.println(three.duplicate(nums));
    }
}
