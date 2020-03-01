package swordfFingerOffer;

import java.util.Stack;

public class ValidateStackSequences_31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length;i ++) {
            stack.push(pushed[i]);
            while (stack.size() != 0 && j < popped.length && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidateStackSequences_31 validateStackSequences_31 = new ValidateStackSequences_31();
        System.out.println(validateStackSequences_31.validateStackSequences(new int[]{1,2,3,4,5} , new int[]{4,5,3,2,1}));
    }

}
