
/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * */
public class MyAtoi_8 {

    public int myAtoi(String str) {
        char arr[] = str.trim().toCharArray();
        if (arr.length == 0)
            return 0;
        long res = 0;
        int i = 0;
        boolean flag = true;
        if (arr[i] == '+')
            i++;
        else if (arr[i] == '-') {
            i++;
            flag = false;
        }

        for (; i < arr.length; i++) {
            int tmp = arr[i] - '0';
            if (tmp < 0 || tmp > 9) break;
            if (flag) {
                res = res * 10 + tmp;
                if (res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else {
                res = res * 10 - tmp;
                if (res < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        MyAtoi_8 myAtoi_8 = new MyAtoi_8();
        System.out.println(myAtoi_8.myAtoi("42"));
    }

}
