package swordfFingerOffer;

/**
 * 面试题44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 */
public class FindNthDigit_44 {

    public int findNthDigit(int n) {
        if (n < 0)
            return -1;
        int dig = 1;
        while (true) {
            long count = countOfInt(dig);
            if (n < count * dig) {
                return digAtIndex(n, dig);
            }
            n -= dig * count;
            dig++;
        }
    }

    private long countOfInt(int dig) {
        if (dig == 1)
            return 10;
        return 9 * (long) Math.pow(10, dig - 1);
    }

    private int digAtIndex(int n, int dig) {
        long num = beginNum(dig) + n / dig;
        long indexFromRight = dig - n % dig;
        for (int i = 1; i < indexFromRight; ++i) {
            num /= 10;
        }
        return (int) (num % 10);
    }

    private long beginNum(int dig) {
        if (dig == 1)
            return 0;
        return (long) Math.pow(10, dig - 1);
    }


    public static void main(String[] args) {
        FindNthDigit_44 findNthDigit_44 = new FindNthDigit_44();

        System.out.println(findNthDigit_44.findNthDigit(1000000000));
    }
}
