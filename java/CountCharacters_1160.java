import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class CountCharacters_1160 {

    public int countCharacters(String[] words, String chars) {
        int res = 0;
        char c[] = chars.toCharArray();
        for (String s : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < c.length; i++) {
                if (map.get(c[i]) == null) {
                    map.put(c[i], 1);
                } else {
                    map.put(c[i], map.get(c[i]) + 1);
                }
            }
            boolean tmp = true;
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null || map.get(s.charAt(i)) == 0) {
                    tmp = false;
                    break;
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                }
            }
            if (tmp)
                res += s.length();
        }
        return res;

    }

    public static void main(String[] args) {
        CountCharacters_1160 countCharacters_1160 = new CountCharacters_1160();
        System.out.println(countCharacters_1160.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
