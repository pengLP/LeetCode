package goldCode;

/**
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * */
public class Massage_1716 {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1)
            return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        for (int i = 2;i < nums.length ;i++) {
            dp[i] = Math.max(dp[i - 1] , dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int massage1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int a = nums[0] , max = Math.max(a , nums[1]);
        for (int i = 2;i < nums.length; i++) {
            int maxTmp = Math.max(max , a + nums[i]);
            a = max;
            max = maxTmp;
        }
        return max;
    }

    public static void main(String[] args) {
        Massage_1716 massage_1716 = new Massage_1716();
        System.out.println(massage_1716.massage1(new int[]{2,1,4,5,3,1,1,3}));
    }
}
