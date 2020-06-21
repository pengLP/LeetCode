package swordfFingerOffer;

import java.util.Stack;

public class MinStack_30 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack_30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            int x = stack.pop();
            if (minStack.size() > 0) {
                if (minStack.peek() == x)
                    minStack.pop();
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_30 minStack_30 = new MinStack_30();
        minStack_30.push(0);
        minStack_30.push(1);
        minStack_30.push(0);
        System.out.println(minStack_30.min());
        minStack_30.pop();
        System.out.println(minStack_30.min());
    }
}
