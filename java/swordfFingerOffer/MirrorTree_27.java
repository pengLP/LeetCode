package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * */
public class MirrorTree_27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
