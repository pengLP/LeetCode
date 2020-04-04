import java.awt.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * */
public class Trap_42 {

    /**
     * 栈
     * */
    public int trap1(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while ( !stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.empty())
                    break;
                int distance = i - stack.peek() - 1;
                int h = Math.min(height[i] , height[stack.peek()]) - height[top];
                ans += distance * h;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 暴力
     * */
    public int trap2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0;
        int n = height.length;
        for (int i = 1;i < n - 1; i++) {
            int max_left = 0 , max_right = 0;
            for (int j = i;j >= 0; j--) {
                max_left = Math.max(max_left , height[j]);
            }
            for (int j = i; j < n; j++) {
                max_right = Math.max(max_right , height[j]);
            }
            res += Math.min(max_left , max_right) - height[i];
        }
        return res;
    }

    /**
     * 动态规划
     * */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int[] dpleft = new int[n];
        int[] dpright = new int[n];
        dpleft[0] = height[0];
        for (int i = 1;i < height.length; i++) {
            dpleft[i] = Math.max(dpleft[i - 1] , height[i]);
        }
        dpright[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dpright[i] = Math.max(dpright[i + 1] , height[i]);
        }
        int ans = 0;
        for (int i = 0;i < n;i ++) {
            ans += Math.min(dpleft[i] , dpright[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap_42 trap_42 = new Trap_42();
        System.out.println(trap_42.trap(new int[]{4,2,3}));
    }

}
