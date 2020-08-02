package algorithm.leedcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * 左 - 根 - 右
 */
public class InorderTraversal_94 {

    //迭代
    public List<Integer> inorderTraversal_2(TreeNode root) {
        return null;

    }


    //递归解答
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> leftResult = inorderTraversal(root.left);
        if (leftResult != null) {
            result.addAll(leftResult);
        }


        result.add(root.val);


        List<Integer> rightResult = inorderTraversal(root.right);
        if (rightResult != null) {
            result.addAll(rightResult);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
