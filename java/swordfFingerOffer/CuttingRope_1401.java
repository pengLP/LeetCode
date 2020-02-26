package swordfFingerOffer;
/**
 * 14；剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * */
public class CuttingRope_1401 {

    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        int []dp = new int[n+1];
        dp[2] = 1;
        for (int i = 1;i <= n; i++){
            for (int j = 0;j <=i/2;j++) {
                dp[i] = Math.max(dp[i] , Math.max((i-j)*j , j * dp[i-j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int r = n % 3;
        long ref = 1l;

        for(int i = 0; i < n / 3 - 1; i++) {
            ref = (ref * 3) % 1000000007;
        }

        if(r == 0) {
            ref = (ref * 3) % 1000000007;
        } else if(r == 1) {
            ref =  (ref * 4) % 1000000007;
        } else if(r == 2) {
            ref = (ref * 6) % 1000000007;
        }
        return (int)ref;
    }

    public static void main(String[] args) {
        CuttingRope_1401 cuttingRope_1401 = new CuttingRope_1401();
        System.out.println(cuttingRope_1401.cuttingRope1(120));
    }
}
