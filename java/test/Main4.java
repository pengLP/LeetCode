package test;

import java.util.*;


public class Main4 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Main4() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void add(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main4 queue = new Main4();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            switch (s) {
                case "add":
                    queue.add(in.nextInt());
                    break;
                case "peek":
                    System.out.println(queue.peek());
                    break;
                case "poll":
                    queue.pop();
                    break;
            }

        }
    }
}
