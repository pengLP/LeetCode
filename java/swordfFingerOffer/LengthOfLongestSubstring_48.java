package swordfFingerOffer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_48 {


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,j = 0,i = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans , j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_48 lengthOfLongestSubstring_48 = new LengthOfLongestSubstring_48();
        System.out.println(lengthOfLongestSubstring_48.lengthOfLongestSubstring("abcabcbb"));
    }
}
