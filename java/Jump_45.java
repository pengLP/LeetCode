


public class Jump_45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int step = 0 , cur = 0,end = 0;
        for (int i = 0;i < nums.length - 1; i++) {
            cur = Math.max(cur , i + nums[i]);
            if (i == end) {
                end = cur;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Jump_45 jump_45 = new Jump_45();
        System.out.println(jump_45.jump(new int[]{2,3,1,1,4}));

    }

}

