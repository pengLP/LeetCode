package tx;

import java.util.HashMap;
import java.util.Map;
/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * */
public class LeetCode_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];

            if (map.get(dif) != null) {
                res[0] = map.get(dif);
                res[1] = i;
                System.out.println(res[1]);
                return res;
            }
            map.put(nums[i] , i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_1 s = new LeetCode_1();
        int res[] = s.twoSum(new int[]{2, 7, 11, 15} , 9);
        for (int i = 0;i < res.length; i++)
            System.out.println(res[i]);
    }
}
