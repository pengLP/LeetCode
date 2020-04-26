import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * */
public class NumberOfSubarrays_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        int left = 0 , right = 0 , count = 0 ,res = 0,pre = 0;
        while (right < nums.length) {
            if (count < k) {
                if (nums[right] % 2 == 1) count++;
                right++;
            }
            System.out.println(pre + "    " + left + "    " + right);
            if (count == k) {
                pre = 0;
                while (count == k) {
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    pre++;
                }
            }else {
                res += pre;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarrays_1248 numberOfSubarrays_1248 = new NumberOfSubarrays_1248();
        System.out.println(numberOfSubarrays_1248.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2} ,2));
    }

}
