
/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow_50 {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n > 0)
            return help(x, n);
        else
            return help(1 / x, -n);
    }


    public double help(double x, long y) {
        if (y == 1)
            return x;
        if (y == 0)
            return 1;
        double half = help(x, y / 2);
        if (y % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }

    public static void main(String[] args) {
        MyPow_50 myPow_50 = new MyPow_50();
        System.out.println(myPow_50.myPow(2, -2147483648));
    }

}
