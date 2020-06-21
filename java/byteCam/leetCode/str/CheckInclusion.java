package byteCam.leetCode.str;

import java.util.Arrays;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        s1 = sortStr(s1);
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (s1.equals(sortStr(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }

    private String sortStr(String str) {
        char cc[] = str.toCharArray();
        Arrays.sort(cc);
        return new String(cc);
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("ab", "eidbaooo"));
    }
}
