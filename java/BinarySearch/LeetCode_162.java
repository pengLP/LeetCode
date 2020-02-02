package BinarySearch;

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
