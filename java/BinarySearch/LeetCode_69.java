package BinarySearch;
/*
* x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
* */
public class LeetCode_69 {
    public int mySqrt(int x) {
        int  low = 0 , high = x/2 + 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if(mid*mid == x)
                return (int)mid;
            if(mid*mid < x)
                low = (int)(mid + 1);
            if(mid*mid > x)
                high = (int)(mid -1);
        }
        return high;
    }

    public static void main(String[] args) {
        LeetCode_69 s = new LeetCode_69();
        System.out.println(s.mySqrt(9));
    }

}
