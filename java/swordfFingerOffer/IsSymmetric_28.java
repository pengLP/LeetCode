package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

/**
 * 面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * */
public class IsSymmetric_28 {

    public boolean isSy(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (right == null && left != null))
            return false;
        if (left == null && right == null)
            return true;
        return (left.val == right.val) && isSy(left.left , right.right) && isSy(left.right , right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSy(root , root);
    }

}
