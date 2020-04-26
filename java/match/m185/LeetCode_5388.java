package match.m185;


import java.util.*;

/**
 * 5388. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * */
public class LeetCode_5388 {

    public String reformat(String s) {
        if (s == null || s.length() == 0) return "";
        Queue<Character> queueNum = new LinkedList<>();
        Queue<Character> queueLetter = new LinkedList<>();
        char arr[] = s.toCharArray();
        for (int i = 0;i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                queueNum.add(arr[i]);
            }else if (arr[i] >= 'a' && arr[i] <= 'z'){
                queueLetter.add(arr[i]);
            }
        }
        if (Math.abs(queueNum.size() - queueLetter.size()) > 1) return "";
        StringBuffer sbf = new StringBuffer();
        int index = 0;
        if(queueNum.size() > queueLetter.size()) {
            Queue<Character> temp = queueNum;
            queueNum = queueLetter;
            queueLetter = temp;
        }
        while (!queueLetter.isEmpty()) {
            sbf.append(queueLetter.poll());
            if (queueNum.isEmpty()){
                continue;
            }else {
                sbf.append(queueNum.poll());
            }
        }

        return sbf.toString();
    }

    public static void main(String[] args) {
        LeetCode_5388 leetCode_5388 = new LeetCode_5388();
        System.out.println(leetCode_5388.reformat("ab123"));
    }

}
