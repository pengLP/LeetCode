import swordfFingerOffer.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * */
public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums , 0 , nums.length);

    }

    public TreeNode helper(int nums[] , int left , int right) {
        if (left == right)
            return null;
        int mid = (left + right) >>> 1;
        System.out.println(nums[mid]);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums , left , mid);
        root.right = helper(nums , mid + 1  , right);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST_108 sortedArrayToBST_108 = new SortedArrayToBST_108();
        System.out.println(sortedArrayToBST_108.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

}
