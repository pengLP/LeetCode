package swordfFingerOffer;
/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * */
public class ReplaceSpace_05 {
    public String replaceSpace(String s) {
        if(s == null)
            return null;
        StringBuffer sbf = new StringBuffer(s);
        System.out.println(sbf.length());
        int p = sbf.length() - 1;
        for(int i = 0;i <=p;i++) {
            System.out.println(sbf.charAt(i));
            if(sbf.charAt(i) == '*')
                sbf.append("**");
        }
        int n = sbf.length()-1;
        while (p >= 0 && p < n) {
            char c = sbf.charAt(p--);
            if (c == '*'){
                sbf.setCharAt(n--, '0');
                sbf.setCharAt(n--, '2');
                sbf.setCharAt(n--, '%');
            }else{
                sbf.setCharAt(n-- , c);
            }
        }
        return sbf.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace_05 replaceSpace_05 = new ReplaceSpace_05();
        System.out.println(replaceSpace_05.replaceSpace("*"));
    }

}
