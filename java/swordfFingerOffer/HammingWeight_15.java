package swordfFingerOffer;
/**
 * 面试题15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * */
public class HammingWeight_15 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n-1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingWeight_15 hammingWeight_15 = new HammingWeight_15();
        System.out.println(hammingWeight_15.hammingWeight(4));
    }

}
