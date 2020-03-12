/**
 * 1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * */

public class GcdOfStrings_1071 {

    int gcd( int a, int b){
        // 已经整除
        return b == 0?a : gcd(b, a%b);
    }

    public String gcdOfStrings(String str1, String str2) {


        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int p = str1.length();
        int q = str2.length();

        int t = gcd(p , q);
        System.out.println(t);
        return str1.substring(0 , t);
    }

    public static void main(String[] args) {
        GcdOfStrings_1071 gcdOfStrings_1071 = new GcdOfStrings_1071();
        System.out.println(gcdOfStrings_1071.gcdOfStrings("ABABAB" , "ABAB"));
    }
}
