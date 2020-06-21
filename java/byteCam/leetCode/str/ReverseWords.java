package byteCam.leetCode.str;

import java.util.Arrays;

/**
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer sbf = new StringBuffer();
        System.out.println(Arrays.toString(strs));
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].equals("")) {
                sbf.append(strs[i] + " ");
            }
        }
        return sbf.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("a good   example"));
    }
}
