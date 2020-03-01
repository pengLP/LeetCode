package match.m178;

import swordfFingerOffer.list.ListNode;
import swordfFingerOffer.tree.TreeNode;

/**
 * 5346. 二叉树中的列表 显示英文描述
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * */
public class Q5346 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null || root == null)
            return true;
        return dfs(head , root) || isSubPath(head , root.right) || isSubPath(head , root.left);
    }

    public boolean dfs(ListNode head , TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return (head.val == root.val) && (dfs(head.next , root.left)||dfs(head.next ,root.right));
    }

}
