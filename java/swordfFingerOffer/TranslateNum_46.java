package swordfFingerOffer;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * */
public class TranslateNum_46 {

    public int translateNum(int num) {
        char c[] = String.valueOf(num).toCharArray();
        if (c.length <= 1)
            return 1;
        int n = c.length;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1;i < n; i++) {
            System.out.println(((c[i]-'0')*10    + (c[i-1]-'0')));
            if (c[i-1] == '0' || ((c[i]-'0') + (c[i-1]-'0')*10) > 25) {
                dp[i + 1] = dp[i];
            }else {
                dp[i + 1] = dp[i] + dp[i-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        TranslateNum_46 translateNum_46 = new TranslateNum_46();
        System.out.println(translateNum_46.translateNum(25));
    }
}
