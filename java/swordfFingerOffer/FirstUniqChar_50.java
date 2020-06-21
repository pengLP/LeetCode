package swordfFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
public class FirstUniqChar_50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == null)
                map.put(c[i], 1);
            else
                map.put(c[i], map.get(c[i]) + 1);
        }

        for (int i = 0; i < c.length; i++)
            if (map.get(c[i]) == 1)
                return c[i];
        return ' ';
    }

}
