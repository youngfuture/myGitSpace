package algorithm.leedcode.binaryTree;

/**
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class BstFromPreorder_1008 {



    //todo
    public TreeNode bstFromPreorder_2(int[] preorder) {

        return null;
    }


    /**
     * 递归
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = add(root, preorder[i]);
        }
        return root;

    }

    public TreeNode add(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (root.val > num) {
            root.left = add(root.left, num);
        } else {
            root.right = add(root.right, num);
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
