package BinarySearch;
/**
 *  寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 * */
public class LeetCode_153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[right])
                right= mid;
            else
                left = mid + 1;
        }
        return nums[right];
    }

    public static void main(String[] args) {
        LeetCode_153 s = new LeetCode_153();
        System.out.println(s.findMin(new int[]{3,3,1,3}));
    }
}
