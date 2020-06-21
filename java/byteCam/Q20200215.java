package byteCam;

import java.util.*;


/**
 * 小q制作了一个简单的游戏：有一排方块，每个方块上是一个自然数或'<'或'>'。小Q一开始在最左边的方块上，且方向向右。
 * 若小Q在数字方块上，他会得到方块上数字对应的分数，并且方块上的数字会减1.特别的，当小q走上数字0方块时，他会得到0分，然后摧毁这个方块，方块数量减一。
 * 若小Q在'<'或'>'方块时，他会改变接下来的前进方向，'>'代表向右，'<'代表向左。特别地，若小Q下一个走到的方块也是'<'或'>'时，他会摧毁这个方块。
 * 当小q走出这排方块边界时，游戏结束，
 */
public class Q20200215 {


    public static int getScore(String str) {
        if (str == null)
            return 0;
        int score = 0;
        int start = 0;
        int toLeft = 1;
        boolean pre = false;
        char cc[] = str.toCharArray();
        while (str.length() > 0 && start >= 0 && start < str.length()) {
            switch (str.charAt(start)) {
                case '>':
                    if (pre) {
                        str = removeCharAt(str, start);
                        pre = false;
                    } else {
                        toLeft = 1;
                        start++;
                        pre = true;
                    }
                    break;
                case '<':
                    if (pre) {
                        str = removeCharAt(str, start);
                        pre = false;
                    } else {
                        toLeft = -1;
                        start--;
                        pre = true;
                    }
                    break;
                default:
                    if (str.charAt(start) == '0') {
                        str = removeCharAt(str, start);
                    } else {
                        score += str.charAt(start) - '0';
                        str = subCharAt(str, start);

                        if (toLeft == 1) {
                            if (str.charAt(start) == '0') {
                                str = removeCharAt(str, start);
                            } else {
                                start += toLeft;
                            }
                        } else {
                            if (str.charAt(start) == '0') {
                                str = removeCharAt(str, start);
                            }
                            start += toLeft;
                        }
                    }
                    pre = false;
                    break;
            }
        }
        return score;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);// 使用substring()方法截取0-pos之间的字符串+pos之后的字符串，相当于将要把要删除的字符串删除
    }

    public static String subCharAt(String s, int index) {
        char cc[] = s.toCharArray();
        cc[index] -= 1;
        return new String(cc);
    }

    public static void main(String[] args) {
        System.out.println(getScore(">2<5>3<"));

    }


}
