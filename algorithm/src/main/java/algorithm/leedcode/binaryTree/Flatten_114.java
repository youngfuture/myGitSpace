package algorithm.leedcode.binaryTree;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *      1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 */
public class Flatten_114 {


    public void flatten(TreeNode root) {




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


