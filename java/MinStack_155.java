import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * */
public class MinStack_155 {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();


    public MinStack_155() {
        this.stack = new Stack();
        this.minStack = new Stack();
    }

    public void push(int x) {
        if (!minStack.empty()) {
            int top = minStack.peek();
            if (x <= top)
                minStack.push(x);
        }else {
            minStack.push(x);
        }
        stack.add(x);
    }

    public void pop() {

        int pop = stack.pop();

        int top = minStack.peek();
        //等于的时候再出栈
        if (pop == top) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack_155 = new MinStack_155();
        minStack_155.push(0);
        minStack_155.push(1);
        minStack_155.push(0);
        System.out.println(minStack_155.getMin());
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
    }

}
