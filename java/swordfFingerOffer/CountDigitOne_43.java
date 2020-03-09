package swordfFingerOffer;

/**
 * 面试题43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * */
public class CountDigitOne_43 {

    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        if (n < 10) return 1;
        char c[] = String.valueOf(n).toCharArray();

        int highNum = c[0] - '0';
        int size = c.length;
        int withoutHigh = n - highNum * (int)Math.pow(10 , size - 1);
        int firstCount = highNum == 1 ? (withoutHigh + 1) : (int)Math.pow(10 , size - 1);

        int otherCOunt = highNum * (size - 1) * (int)Math.pow(10 , size - 2);


        return firstCount + otherCOunt + countDigitOne(withoutHigh);
    }

    public static void main(String[] args) {
        CountDigitOne_43 countDigitOne_43 = new CountDigitOne_43();
        System.out.println(countDigitOne_43.countDigitOne(12));
    }
}
