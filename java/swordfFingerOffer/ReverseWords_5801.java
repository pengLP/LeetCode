package swordfFingerOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * */
public class ReverseWords_5801 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        List<String> strings = Arrays.asList(s.split(" "));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strings.size() -1; i>= 0; i--) {
            if (!strings.get(i).equals("")) {
                stringBuffer.append(strings.get(i) + " ");
            }
        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords_5801 reverseWords_5801 = new ReverseWords_5801();
        System.out.println(reverseWords_5801.reverseWords(" "));
    }
}
