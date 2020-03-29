package dp;

import java.util.*;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * */
public class WordBreak_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String word:wordDict) {
            maxLen = Math.max(word.length() , maxLen);
            set.add(word);
        }
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1;i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = Math.max(0 , i - maxLen);j < i;j ++) {
                if (dp[j].size() > 0 && set.contains(s.substring(j , i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }

        return dp[s.length()];
    }

}
