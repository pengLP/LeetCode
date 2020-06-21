import javafx.beans.binding.When;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class MyStack_225 {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack_225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
        this.top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int res = q1.poll();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.q1.isEmpty() && this.q2.isEmpty();
    }
}
