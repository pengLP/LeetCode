package swordfFingerOffer;

import swordfFingerOffer.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * */
public class BuildTree_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(preorder[0]);
        int index = getNums(treeNode.val , inorder);
        treeNode.left = buildTree(Arrays.copyOfRange(preorder , 1, index + 1) , Arrays.copyOfRange(inorder ,0 , index ));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder , index + 1 , preorder.length) , Arrays.copyOfRange(inorder , index + 1 , inorder.length));
        return treeNode;
    }

    private int getNums(int target , int[] inroder) {

        for (int i = 0;i < inroder.length;i ++) {
            if (inroder[i] == target)
                return i;
        }
        return -1;
    }

    public static void printTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.println(t.val);

            if (t.left != null)
                queue.offer(t.left);
            if (t.right != null)
                queue.offer(t.right);
        }
    }

    public static void main(String[] args) {
        BuildTree_07 buildTree_07 = new BuildTree_07();
        printTree(buildTree_07.buildTree(new int[]{3,9,20,15,7} , new int[]{9,3,15,20,7}));
    }
}
