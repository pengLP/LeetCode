import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * */
public class GenerateParenthesis_22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        solve(0 , n * 2, sb);
        return res;
    }

    private void solve(int leftCnt, int n, StringBuffer sb) {

        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        if (leftCnt > 0) {
            sb.append(')');
            solve(leftCnt - 1 , n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n - sb.length() > leftCnt) {
            sb.append("(");
            solve(leftCnt + 1 , n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParenthesis_22 generateParenthesis_22 = new GenerateParenthesis_22();
        System.out.println(generateParenthesis_22.generateParenthesis(3));
    }
}
