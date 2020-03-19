package test;


import java.util.*;

public class Main {

    public static int getCricle(int nums[]) {
        Arrays.sort(nums);
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < nums.length; i++) {
            if (i % 2 == 0)
                queue.add(nums[i]);
            else
                stack.push(nums[i]);
        }
        while (!stack.empty()) {
            queue.add(stack.pop());
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        int max = 0;
        for (int i = 0;i < res.size() - 1;i++) {
            max = Math.max(res.get(i+1) - res.get(i) , max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0;i < nums.length; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(getCricle(nums));
    }

}
