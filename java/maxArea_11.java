
/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class maxArea_11 {

    /**
     * 暴力法
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }

        return max;
    }

    /**
     * 双指针
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        maxArea_11 maxArea_11 = new maxArea_11();
        System.out.println(maxArea_11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
