package swordfFingerOffer;

import javax.swing.*;

/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * */
public class MinArray_11 {

    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right--;
            }
        }
        System.out.println(right);
        return numbers[right];
    }

    public static void main(String[] args) {
        MinArray_11 minArray_11 = new MinArray_11();
        System.out.println(minArray(new int[]{3,3,1,3}));
    }



}
