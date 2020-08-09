package algorithm.leedcode.binaryTree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 * <p>
 * 后序遍历最后一个节点为根
 */
public class VerifyPostorder_Offer_33 {

    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }

        int p = i;
        //找到左子树
        while (postorder[p] < postorder[j]) {
            p++;
        }

        int m = p;
        //找到右子树
        while (postorder[p] > postorder[j]) {
            p++;
        }

        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }


}
