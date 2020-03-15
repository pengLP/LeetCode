package swordfFingerOffer;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * */
public class MissingNumber_5302 {

    public int missingNumber(int[] nums) {
        int low = 0 , high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] != mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }


    public static void main(String[] args) {
        MissingNumber_5302 missingNumber_5302 = new MissingNumber_5302();
        System.out.println(missingNumber_5302.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }
}
