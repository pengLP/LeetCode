package swordfFingerOffer.dataStructuresAndAlgorithms.recursive;

/**
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class Fibonacci_10 {

    public int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci1(int n) {
        int a[] = new int[n + 1];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        Fibonacci_10 fibonacci_10 = new Fibonacci_10();
        System.out.println(fibonacci_10.fibonacci1(10));
    }

}
