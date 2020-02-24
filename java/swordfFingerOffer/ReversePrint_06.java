package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * */
public class ReversePrint_06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            int val = head.val;
            head = head.next;
            stack.push(val);
        }
        int res[] = new int[stack.size()];
        int i = 0;
        while (stack.size() != 0) {
            res[i++] = stack.pop();
        }
        return res;
    }

}
