package swordfFingerOffer;

/**
 * 面试题65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * */
public class Add_65 {

    public int add(int a, int b) {
        int sum , carry;
        while (b !=0) {
            sum = a ^ b;
            System.out.println(sum);
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }




    public static void main(String[] args) {
//        Add_65 add_65 = new Add_65();
//        System.out.println(add_65.add(1,1));

    }

}
