import swordfFingerOffer.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
        return dg(root, null, null);
    }

    private boolean dg(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        if (!dg(node.right, node.val, upper)) return false;
        if (!dg(node.right, node.val, upper)) return false;
        if (!dg(node.left, lower, node.val)) return false;

        return true;
    }
}
