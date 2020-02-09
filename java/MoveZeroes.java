
/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * */
public class MoveZeroes {
    public static  void moveZeroes(int[] nums) {
        int high = nums.length - 1;
        while (high >= 0) {
            if(nums[high] == 0) {
                for (int i = high; i < nums.length-1; i++) {
                    nums[i] = nums[i+1];
                }
                nums[nums.length - 1] = 0;
            }
            high--;
        }
    }

    public static void main(String[] args) {
        MoveZeroes s = new MoveZeroes();
        int num[] = new int[]{0,1,0,3,12};
        moveZeroes(num);
        for (Integer i:num) {
            System.out.println(i);
        }
    }

}
