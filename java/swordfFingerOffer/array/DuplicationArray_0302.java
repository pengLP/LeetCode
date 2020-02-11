package swordfFingerOffer.array;
/**
 * 在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内。所以数组中至少有一个数字是重复的。
 * 请找出数值中任意一个重复的数字，但不能修改输入的数组。
 * 例如，输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3
 * */
public class DuplicationArray_0302 {

    public int getDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 1 , end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int count = countRange(nums , start , mid);
            if (start == end){
                if (count > 1)
                    return start;
                else
                    return -1;
            }
            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    private int countRange(int nums[] , int start , int end ) {
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0 ;i < nums.length ;i ++) {
            if (nums[i] >= start && nums[i] <= end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        DuplicationArray_0302 duplicationArray_0302 = new DuplicationArray_0302();
        System.out.println(duplicationArray_0302.getDuplicate(new int[]{1}));
    }
}
