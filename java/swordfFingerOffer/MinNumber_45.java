package swordfFingerOffer;

import java.util.Arrays;

/**
 * 面试题45. 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 */
public class MinNumber_45 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        String numStrs[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String res = "";
        for (String s : numStrs) {
            res += s;
        }
        return res;
    }

}

