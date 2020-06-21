import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 */
public class MinimumLengthEncoding_820 {

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : words) {
            for (int i = 1; i < s.length(); i++) {
                set.remove(s.substring(i, s.length()));
            }
        }
        int ans = 0;
        for (String s : set) {
            ans += s.length() + 1;
        }

        return ans;

    }

    public static void main(String[] args) {
        MinimumLengthEncoding_820 minimumLengthEncoding_820 = new MinimumLengthEncoding_820();
        System.out.println(minimumLengthEncoding_820.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

}
