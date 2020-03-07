package swordfFingerOffer;

public class MajorityElement_39 {

    public int majorityElement(int[] nums) {
        int n = 1;
        int res = nums[0];
        for (int i = 1;i < nums.length; i++) {
            if (n == 0) {
                res = nums[i];
                n = 1;
            }else if (nums[i] == res) {
                n++;
            }else {
                n--;
            }
        }
        return res;
    }

}
