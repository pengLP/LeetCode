package swordfFingerOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class LastRemaining_62 {


    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {

        int f = 0;
        for (int i = 2; i <= n + 1; i++) {
            f = (m + f) % i;
        }
        return f;

    }

    public static void main(String[] args) {
        LastRemaining_62 lastRemaining_62 = new LastRemaining_62();
        System.out.println(lastRemaining_62.lastRemaining1(10, 17));
    }


}
