package swordfFingerOffer;

public class ReverseLeftWords_5802 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() < n)
            return s;
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        ReverseLeftWords_5802 reverseLeftWords_5802 = new ReverseLeftWords_5802();
        System.out.println(reverseLeftWords_5802.reverseLeftWords("abcdefg", 2));
    }
}
