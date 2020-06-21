/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= (i ^ nums[i]);
        }

        return n;
    }

    public static void main(String[] args) {
        MissingNumber_268 missingNumber_268 = new MissingNumber_268();
        System.out.println(missingNumber_268.missingNumber(new int[]{3, 0, 1}));
    }


}
