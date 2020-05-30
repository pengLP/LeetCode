package test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int k = 0;k < num; k++) {
            int n = in.nextInt();
            queue = new LinkedList<>();
            for (int i = 0;i < n; i++) {
                String str = in.next();
                switch (str) {
                    case "PUSH":
                        queue.offer(in.nextInt());break;
                    case "TOP":
                        if (queue.size() <= 0) {
                            System.out.println(-1);
                            continue;
                        }
                        System.out.println(queue.peek());break;
                    case "POP":
                        if (queue.size() <= 0){
                            System.out.println(-1);
                            continue;
                        }
                        queue.poll();
                        break;
                    case "SIZE":
                        System.out.println(queue.size());break;
                    case "CLEAR":
                        queue.clear();
                        break;
                }
            }
        }

    }



}
