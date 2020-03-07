package swordfFingerOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue_5902 {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue_5902() {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (deque.size() > 0 && deque.getLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }


    public int pop_front() {
        int tmp = queue.size() > 0 ? queue.poll() : -1;
        if (deque.size() > 0 && tmp == deque.peek())
            deque.poll();
        return tmp;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque.peek());
        System.out.println(deque);
        deque.offerFirst(4);
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);

    }

}
