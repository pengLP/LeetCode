package swordfFingerOffer;

/**
 * 面试题67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * */
public class StrToInt_67 {

    public int strToInt(String str) {
        if (str == null || str.trim().length() == 0)
            return 0;
        str = str.trim();
        String res = "";
        int i = 0;
        if (str.charAt(0)== '+' || str.charAt(0) == '-'){
            res += str.charAt(0);
            i++;
        }

        for (;i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res+= str.charAt(i);
            }else {
                break;
            }

        }
        if (res.length()== 0 || res.equals("+") || res.equals("-"))
            return 0;
        try {
            long ans = Long.parseLong(res);
            if (ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)ans;
        }catch (NumberFormatException e) {
            if (res.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        StrToInt_67 strToInt_67 = new StrToInt_67();
        System.out.println(strToInt_67.strToInt("0000000000012345678\"    "));
    }

}
