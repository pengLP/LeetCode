package swordfFingerOffer.array;

public class ReplaceSpaces_05 {

    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        int p = str.length() - 1;
        for (int i = 0; i <= p; i++) {
            if (str.charAt(i) == ' ')
                str.append("  ");
        }
        int q = str.length() - 1;
        while (p >= 0 && q > p) {
            char c = str.charAt(p--);
            if (c == ' ') {
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            } else {
                str.setCharAt(q--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpaces_05 replaceSpaces_05 = new ReplaceSpaces_05();
        System.out.println(replaceSpaces_05.replaceSpace(new StringBuffer("")));
    }

}
