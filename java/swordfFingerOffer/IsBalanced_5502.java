package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced_5502 {

    private int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size-- >= 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        boolean mid = false;
        if (left - right >= -1 && left - right <= 1)
            mid = true;

        boolean leftIsBalanced = isBalanced(root.left);
        boolean rightIsBalanced = isBalanced(root.right);


        return mid && leftIsBalanced && rightIsBalanced;
    }

}
