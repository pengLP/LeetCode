package swordfFingerOffer;


/**
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，
 * 请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow_5901 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return new int[]{};
        int res[] = new int[nums.length - k + 1];
        int end = k - 1;
        for (int i = 0; i <= nums.length - k; i++, end++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= end; j++) {
                max = Math.max(nums[j], max);
            }
            res[i] = max;

        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow_5901 maxSlidingWindow_5901 = new MaxSlidingWindow_5901();
        int res[] = maxSlidingWindow_5901.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
