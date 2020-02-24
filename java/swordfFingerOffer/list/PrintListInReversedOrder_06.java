package swordfFingerOffer.list;

import java.util.ArrayList;
import java.util.Stack;



public class PrintListInReversedOrder_06 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.empty()){
            res.add(stack.pop());
        }
        return res;
    }

}
