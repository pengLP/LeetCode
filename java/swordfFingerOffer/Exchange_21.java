package swordfFingerOffer;
/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * */
public class Exchange_21 {

    public int[] exchange(int[] nums) {
        if(nums == null && nums.length == 0){
            return nums;
        }
        int start = 0 , end = nums.length - 1;
        while (start < end) {
            while (start < end && (nums[start] % 2) != 0) {
                start++;
            }
            while (start < end && (nums[end] % 2) == 0) {
                end--;
            }
            if (start < end) {
                int t = nums[start];
                nums[start] = nums[end];
                nums[end] = t;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange_21 exchange_21 = new Exchange_21();
        int res[] = exchange_21.exchange(new int[]{1,2,3,4});
        for (Integer i:res) {
            System.out.println(i);
        }
    }
}
