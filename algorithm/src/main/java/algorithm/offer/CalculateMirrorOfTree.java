package algorithm.offer;

/**
 * 二叉树的镜像定义：源二叉树
   	     8
   	   /  \
   	  6   10
   	 / \  / \
   	5  7 9 11

   	镜像二叉树
   	     8
   	   /  \
   	  10   6
   	 / \  / \
   	11 9 7  5
 *
 *
 *操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CalculateMirrorOfTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        //左右孩子都为空就退出，否则递归求
        if (leftChild == null && rightChild == null) {
            return;
        } else {
            root.left = rightChild;
            root.right = leftChild;
            Mirror(rightChild);
            Mirror(leftChild);
        }
    }


}
