
public class NumSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        for(int i = 1;i<= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1;j*j <= i; ++j) {
                if(dp[i-j*j]+1 < dp[i]) {
                    dp[i] = dp[i-j*j]+1;
                }
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public boolean isSquare(int n){
        int num = (int) Math.sqrt(n);
        return n == num * num;
    }

    public static void main(String[] args) {
        NumSquares s = new NumSquares();
        System.out.println(s.numSquares(13));
    }
}
