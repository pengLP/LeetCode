package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * */
public class MinimumTotal_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int dp[] = new int[triangle.size()];
        for (int i = 0;i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = triangle.get(0).get(0);
        for (int i = 1;i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j != 0)
                    dp[j] = Math.min(dp[j] , dp[j - 1]) + triangle.get(i).get(j);
                else
                    dp[j] = dp[j] + triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i < dp.length; i++)
            ans = Math.min(dp[i] , ans);
        return ans;
    }

    public static void main(String[] args) {
        MinimumTotal_120 minimumTotal_120 = new MinimumTotal_120();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        System.out.println(minimumTotal_120.minimumTotal(lists));
    }

}
