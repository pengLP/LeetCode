package swordfFingerOffer;

/**
 * 面试题56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 * */
public class SingleNumber_5602 {

    public int singleNumber(int[] nums) {
        int bitSum[] = new int[32];
        for (int i = 0;i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; --j) {
                int bit = nums[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int res = 0;
        for (int i = 0;i < 32; ++i) {
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber_5602 singleNumber_5602 = new SingleNumber_5602();
        System.out.println(singleNumber_5602.singleNumber(new int[]{3,4,3,3} ));
    }
}
