import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * */
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        List<Integer> output = new ArrayList<>();
        for (int i = 0;i < nums.length; i++) {
            output.add(nums[i]);
        }
        backtrack(nums.length , res , output , 0);
        return res;
    }

    private void backtrack(int n, List<List<Integer>> res , List<Integer> output , int first) {

        if (n == first)
            res.add(new ArrayList<>(output));
        for (int i = first; i < n; i++) {
            Collections.swap(output , first , i);
            backtrack(n , res , output , first + 1);
            Collections.swap(output , first , i);
        }
    }

    public static void main(String[] args) {
        Permute_46 permute_46 = new Permute_46();
        System.out.println(permute_46.permute(new int[]{1,2,3}));
    }

}
