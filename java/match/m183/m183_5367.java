package match.m183;

import java.util.*;

/**
 * 5376. 非递增顺序的最小子序列 显示英文描述
 * 题目难度Easy
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * <p>
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * <p>
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 */
public class m183_5367 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (Integer i : nums)
            sum += i;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
            int tsum = 0;
            for (Integer j : list) tsum += j;
            if (tsum > sum - tsum) break;
        }
        return list;
    }

    public static void main(String[] args) {
        m183_5367 m183_5367 = new m183_5367();
        System.out.println(m183_5367.minSubsequence(new int[]{7, 4, 2, 8, 1, 7, 7, 10}));
    }
}
