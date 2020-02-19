package swordfFingerOffer.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */


public class ConstructBinaryTree_07 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        int index = search(0 , in.length , in , treeNode.val);
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1 , index+1) , Arrays.copyOfRange(in , 0 , index));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1 , pre.length) , Arrays.copyOfRange(in , index+1,in.length));
        return treeNode;

    }

    private static int search(int start, int end , int orders[], int data) {
        for (int i = start;i < end; i++) {
            if (orders[i] == data)
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
        ConstructBinaryTree_07 constructBinaryTree_07 = new ConstructBinaryTree_07();
        TreeNode treeNode = constructBinaryTree_07.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8} , new int[]{4,7,2,1,5,3,8,6});
        printTree(treeNode);
    }
}
