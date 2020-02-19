package swordfFingerOffer.tree;

import swordfFingerOffer.tree.TreeNode;

/**
 *  面试题8：二叉树的下一个结点
 *  题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *  树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * */


public class NextNodeInBinaryTrees_08 {

    public TreeNode nextNodeInBinaryTrees(TreeNode treeNode) {
        if (treeNode == null)
            return null;
        if (treeNode.right != null) {
            TreeNode node = treeNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }else {
            while (treeNode.parent != null) {
                TreeNode parent = treeNode.parent;
                if (parent.left == treeNode)
                    return parent;
                treeNode = treeNode.parent;
            }
        }
        return null;
    }

}
