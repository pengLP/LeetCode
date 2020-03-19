import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * */
public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int ans = 0;
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0;i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i) , map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i) , 1);
            }
        }
        for(Integer v:map.values())
        {
            ans += v /2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome_409 longestPalindrome_409 = new LongestPalindrome_409();
        System.out.println(longestPalindrome_409.longestPalindrome("abccccdd"));
    }

}
