package goldCode;


/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class CompressString_0106 {

    public String compressString(String S) {
        if (S == null || S.length() <= 1)
            return S;
        StringBuffer sb = new StringBuffer().append(S.charAt(0));
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt).append(S.charAt(i));
                cnt = 1;
            }
        }

        return sb.append(cnt).length() < S.length() ? sb.toString() : S;
    }

    public static void main(String[] args) {
        CompressString_0106 compressString_0106 = new CompressString_0106();
        System.out.println(compressString_0106.compressString("aabcccccaaa"));
    }
}
