package match.m180;

public class LeetCode_5357 {

    private int top;
    private int[] data;
    private int maxSize;

    public LeetCode_5357(int maxSize) {
        this.data = new int[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (this.top < this.maxSize-1) {
            this.top++;
            this.data[this.top] = x;
        }
    }

    public int pop() {
        if (this.top == -1)
            return -1;
        else {
            int num = this.data[this.top];
            this.top--;
            return num;
        }
    }

    public void increment(int k, int val) {
        if (k > this.top) {
            for (int i = 0;i <= this.top; i++) {
                this.data[i] += val;
            }
        }else {
            for (int i =0 ;i < k;i++) {
                this.data[i]+= val;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_5357 stack = new LeetCode_5357(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5 , 100);
        stack.increment(2 , 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
