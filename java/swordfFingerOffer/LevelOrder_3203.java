package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * */
public class LevelOrder_3203 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int tmp = 1;
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (tmp % 2 == 1) {
                    if (treeNode.left != null)
                        queue.add(treeNode.left);
                    if (treeNode.right != null)
                        queue.add(treeNode.right);
                }else {
                    if (treeNode.right != null)
                        queue.add(treeNode.right);
                    if (treeNode.left != null)
                        queue.add(treeNode.left);
                }

            }
            res.add(list);
        }
        return res;
    }

}
