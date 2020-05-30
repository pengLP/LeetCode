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
        int res = 0 , cur = 0;
        for(int i = 0;i < s.length(); i++) {
            if(s.charAt(i) == '1')
                cur++;
        }
        for(int i = 0;i < s.length() - 1; i++) {
            if(s.charAt(i) == '0')
                cur++;
            else
                cur--;
            res = Math.max(cur , res);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_5392 leetCode_5392 = new LeetCode_5392();
        System.out.println(leetCode_5392.maxScore("011101"));
    }

}
