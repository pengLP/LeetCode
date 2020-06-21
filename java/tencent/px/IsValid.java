package tencent.px;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * */
public class IsValid {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')'){
                if (stack.pop()  != '(')
                    return false;
            }else if (c == ']'){
                if (stack.pop()  != '[')
                    return false;
            }else if (c == '}'){
                if (stack.pop()  != '{')
                    return false;
            }
        }

        return stack.size() == 0;
    }
    

}
