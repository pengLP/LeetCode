package swordfFingerOffer;

/**
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * */
public class ConstructArr_66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return new int[]{};
        int b[] = new int[a.length];
        b[0] = 1;
        for (int i = 1;i < a.length; i++) {
            b[i] = b[i-1]*a[i-1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i+1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        ConstructArr_66 constructArr_66 = new ConstructArr_66();
        constructArr_66.constructArr(new int[]{1,2,3,4,5});
    }

}
