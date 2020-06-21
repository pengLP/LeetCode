package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

import java.util.Objects;

/**
 * 面试题54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class KthLargest_54 {

    private int index = 0;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        index = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (Objects.nonNull(root)) {
            dfs(root.right);
            if (index == 1) {
                this.res = root.val;
            }
            index--;
            dfs(root.left);
        }
    }

}
