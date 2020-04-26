
/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * */
public class CanJump_55 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= curr) {
                curr = Math.max(curr , i + nums[i]);
                if (curr >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }



}
