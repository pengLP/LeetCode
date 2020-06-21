import swordfFingerOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class DiameterOfBinaryTree_543 {

    private int sum = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.sum;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        this.sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Object o = new Object();
        List<Object> list1 = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list1.add(o);
        }
        System.out.println(System.currentTimeMillis() - start);

        List<Object> list2 = new ArrayList<>(n);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list2.add(o);
        }
        System.out.println(System.currentTimeMillis() - start2);
    }


}
