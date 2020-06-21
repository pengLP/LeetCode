package match.m183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 5377. 将二进制表示减到 1 的步骤数 显示英文描述
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 */
public class m183_5377 {

    public int numSteps(String s) {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        int res = 0;
        while (!(list.size() == 1 && list.get(0) == '1')) {
            if (list.get(list.size() - 1) == '1') {
                add(list);
            } else {
                list.remove(list.size() - 1);
            }
            res++;
        }
        return res;
    }

    public void add(List<Character> list) {
        list.set(list.size() - 1, '0');
        int jin = 1;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (jin == 1) {
                if (list.get(i) == '0') {
                    list.set(i, '1');
                    jin = 0;
                } else {
                    list.set(i, '0');
                    jin = 1;
                }
            } else {
                break;
            }
        }
        if (jin == 1) {
            list.add(0, '1');
        }
    }


    public static void main(String[] args) {
        m183_5377 m183_5377 = new m183_5377();
        System.out.println(m183_5377.numSteps("1101"));
    }

}
