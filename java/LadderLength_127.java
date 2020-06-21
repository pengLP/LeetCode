import javafx.util.Pair;

import java.util.*;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 */
public class LadderLength_127 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int l = beginWord.length();
        Map<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < word.length(); i++) {
                        String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
                        ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                }
        );


        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();

            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
                for (String adjacent : allComboDict.getOrDefault(newWord, new ArrayList<>())) {

                    if (adjacent.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacent)) {
                        visited.put(adjacent, true);
                        queue.add(new Pair<>(adjacent, level + 1));
                    }
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        LadderLength_127 ladderLength_127 = new LadderLength_127();
        System.out.println(ladderLength_127.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
}
