import java.util.ArrayList;
import java.util.List;

public class LeetCode_17 {
    public List<String> letterCombinations(String digits) {
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        res.add("");
        for (char c:digits.toCharArray()) {
            List<String> list = new ArrayList<>();
            for (char ch: map[c - '0'].toCharArray()) {
                for (String s:res) {
                    list.add(s+ch);
                }
            }
            res = list;
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_17 s = new LeetCode_17();
        System.out.println(s.letterCombinations("23"));
    }
}
