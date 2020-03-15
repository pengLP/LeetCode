package swordfFingerOffer;

import java.util.Arrays;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * */
public class Search_5301 {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)>>>1;
            System.out.println(mid);
             if (nums[mid] == target) {
                int l = mid , r = mid;
                while (l - 1 >= 0 && nums[l-1] == target){
                    l--;
                }
                while (r + 1 < nums.length && nums[r+1] == target){
                    r++;
                }
                return r - l +1;
             }
             if (nums[mid] > target) {
                 right = mid - 1;
             }else{
                 left = mid + 1;
             }
        }
        return 0;
    }

    public static void main(String[] args) {
//        Search_5301 search_5301 = new Search_5301();
//        Arrays.copyOfRange(new int[]{5,7,7,8,8,10} , 3 ,4);
//        System.out.println(search_5301.search(new int[]{5,7,7,8,8,10} , 6));

        
    }
}
