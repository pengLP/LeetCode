package swordfFingerOffer;

/**
 * 面试题43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * */
public class CountDigitOne_43 {

    public int countDigitOne(int n) {
        int high = n;
        int sum = 0;
        while (high > 0) {
            String tmp = String.valueOf(high);
            for (int i  = 0;i < tmp.length(); i++) {
                if (tmp.charAt(i) == '1'){
                    sum++;
                }
            }
            high--;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountDigitOne_43 countDigitOne_43 = new CountDigitOne_43();
        System.out.println(countDigitOne_43.countDigitOne(12));
    }
}
