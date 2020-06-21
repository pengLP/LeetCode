package swordfFingerOffer;

import java.util.List;

/**
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class PrintNumbers_17 {


    public int[] printNumbers(int n) {
        int nMax = (int) Math.pow(10, n);
        int res[] = new int[nMax - 1];
        for (int i = 1; i < nMax; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintNumbers_17 printNumbers_17 = new PrintNumbers_17();
        int a[] = printNumbers_17.printNumbers(1);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
