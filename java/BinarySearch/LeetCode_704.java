package BinarySearch;

/*
* 二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* */
public class LeetCode_704 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low = mid + 1;
            if (nums[mid] > target)
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_704 s = new LeetCode_704();
        System.out.println(s.search(new int[]{5}, 5));
    }
}
