package BinarySearch;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * */
public class LeetCode_162 {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        int left = 0 , right = nums.length - 1;

        return find(nums , left , right);
    }

    public static int find(int[] nums, int left , int right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1])
            return mid;
        if(nums[mid-1] > nums[mid])
            return find(nums , left , mid);
        else
            return find(nums , mid , right);
    }

    public static void main(String[] args) {
        LeetCode_162 s = new LeetCode_162();
        System.out.println(s.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
