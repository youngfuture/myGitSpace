package algorithm.leedcode.binaryTree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 前序遍历 (根-左-右)
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal_144 {

    /**
     * 递归解
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);

        List<Integer> leftResult = preorderTraversal(root.left);
        if (leftResult != null) {
            result.addAll(leftResult);
        }

        List<Integer> rightResult = preorderTraversal(root.right);
        if (rightResult != null) {
            result.addAll(rightResult);
        }

        return result;
    }


    /**
     * 迭代,非递归，通过栈模拟函数调用的先后顺序
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            result.add(tempNode.val);

            if (tempNode.right != null) {
                stack.add(tempNode.right);
            }

            if (tempNode.left != null) {
                stack.add(tempNode.left);
            }
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
