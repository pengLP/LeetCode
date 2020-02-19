package swordfFingerOffer.queueandstack;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
public class QueueWithTwoStacks_09 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public Integer pop() {
        if (stack2.size() <= 0) {
            while (!stack1.empty()) {
                int node = stack1.pop();
                stack2.push(node);
            }
        }
        if (stack2.size() == 0)
            return null;
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks_09 queue = new QueueWithTwoStacks_09();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());

        System.out.println(queue.pop());

        System.out.println(queue.pop());
    }
}
