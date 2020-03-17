package swordfFingerOffer;

import java.util.Arrays;

public class IsStraight_61 {

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0;i < nums.length-1; i++) {
            if (nums[i] == 0) {
                cnt++;
            }else {
                int cha = nums[i + 1] - nums[i]-1;
                if (cha == -1)
                    return false;
                cnt -= cha;
                if (cnt < 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsStraight_61 isStraight_61 = new IsStraight_61();
        System.out.println(isStraight_61.isStraight(new int[]{0,0,2,2,5}));
    }

}
