package swordfFingerOffer;

import org.w3c.dom.ls.LSOutput;
import swordfFingerOffer.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 面试题55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class MaxDepth_5501 {

    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "12313123", "bc", "efg", "abcd", "", "jkl");
        strings.stream().sorted().forEach(System.out::println);
        strings.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

}
