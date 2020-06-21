import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class SubarraySum_560 {

    /**
     * 枚举法
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /*哈希法*/
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
                System.out.println(i + "   " + pre + "   " + k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum_560 subarraySum_560 = new SubarraySum_560();
        System.out.println(subarraySum_560.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }

}
