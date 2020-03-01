package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * */
public class LevelOrder_3201 {

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null)
                queue.add(treeNode.left);
            if (treeNode.right != null)
                queue.add(treeNode.right);
        }
        int res[] = new int[list.size()];
        for (int i = 0;i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

}
