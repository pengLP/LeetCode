package dp;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * */
public class NumDecodings_91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int dp[] = new int[s.length() + 1];
        char arr[] = s.toCharArray();
        dp[0] = 1;
        dp[1] = arr[0] == '0'?0:1;
        int n = s.length();
        for (int i = 2;i <= n; i++) {
            if (arr[i - 2] == '0' && arr[i - 1] == '0')
                return 0;
            int tmp = (arr[i - 2]- '0') * 10 + (arr[i - 1] - '0');
            if (arr[i - 2] == '0') {
                dp[i] = dp[i - 1];
            }else if (arr[i - 1] == '0') {
                if (tmp > 26)
                    return 0;
                dp[i] = dp[i - 2];
            }else if (tmp > 26){
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumDecodings_91 numDecodings_91 = new NumDecodings_91();
        System.out.println(numDecodings_91.numDecodings("27"));
    }
}
