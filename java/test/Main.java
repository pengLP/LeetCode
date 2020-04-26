package test;

import java.util.Arrays;

public class Main {

    public static int getMiddle(int nums[]) {
        int index = nums.length / 2;
        int left = 0 , right = nums.length -1 ,q = -1;
        while (q != index) {
            System.out.println(Arrays.toString(nums));
            q = partition(nums , left , right);
            if (q < index) {
                left = q + 1;
            }else {
                right = q - 1;
            }
        }
        return nums[index];
    }

    private static int partition(int nums[] , int left , int right) {
        int p = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= p)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= p)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = p;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(getMiddle(new int[]{4,6,2,3,5,7,4,3}));
    }

}
