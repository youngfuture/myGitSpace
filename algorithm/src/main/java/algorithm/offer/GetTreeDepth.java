package algorithm.offer;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class GetTreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public class Solution2 {
        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int nLelt = TreeDepth(root.left);
            int nRight = TreeDepth(root.right);

            return nLelt > nRight ? (nLelt + 1) : (nRight + 1);
        }
    }


    public class Solution {
        public int TreeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            int depth = 1;

            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);

            if (leftDepth >= rightDepth) {
                depth += leftDepth;
            } else {
                depth += rightDepth;
            }

            return depth;
        }
    }
}
