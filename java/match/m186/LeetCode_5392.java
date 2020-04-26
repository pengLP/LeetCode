package match.m186;

import java.util.Arrays;

/**
 * 5392. 分割字符串的最大得分 显示英文描述
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串
 * \（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * */
public class LeetCode_5392 {

    public int maxScore(String s) {
        if (s == null || s.length() == 1)
            return 0;
        if (s.length() == 2) {
            if (s.charAt(0) == '0' && s.charAt(1) == '1')
                return 2;
            return 1;
        }
        int res = 0;
        for (int i = 0;i < s.length(); i++) {
            int sum = 0;
            for (int left = 0;left <= i; left++){
                if (s.charAt(left) == '0')
                    sum++;
            }
            for (int right = s.length() - 1; right > i; right--){
                if (s.charAt(right) == '1')
                    sum++;
            }
            res = Math.max(res , sum);
        }

        return res;

    }

    public static void main(String[] args) {
        LeetCode_5392 leetCode_5392 = new LeetCode_5392();
        System.out.println(leetCode_5392.maxScore("00"));
    }

}
