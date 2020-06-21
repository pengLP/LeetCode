import java.util.Arrays;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords_151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        List<String> list = Arrays.asList(s.split(" "));
        StringBuffer sbf = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get(i).equals("")) {
                sbf.append(list.get(i) + " ");
            }
        }
        return sbf.toString().trim();
    }

}
