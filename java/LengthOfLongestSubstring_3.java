import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0,right = 0 ;left < s.length() && right < s.length();) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }else {
                set.add(s.charAt(right++));
                res = Math.max(res , set.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring_3 = new LengthOfLongestSubstring_3();
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring("pwwkew"));
    }


}
