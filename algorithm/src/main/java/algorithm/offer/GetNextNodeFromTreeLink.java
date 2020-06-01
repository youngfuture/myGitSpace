package algorithm.offer;

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 中序遍历：左-根-右
 * <p>
 * <p>
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class GetNextNodeFromTreeLink {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;

        //指向父亲节点
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {

            if (pNode == null) {
                return null;
            }

            /**
             * 如果当前节点有右孩子，根据 中序遍历：左根右的原则
             * 当前节点的左孩子和当前节点已经输出了，下一个节点就是当前节点右子树中的最左的那个节点
             *
             */
            if (pNode.right != null) {
                pNode = pNode.right;

                while (pNode.left != null) {
                    pNode = pNode.left;
                }
                return pNode;
            }

            /**
             * 如果当前节点的父几点不为空，则说明当前是子节点
             *     如果当前节点是一个左子树，根据“左根右” 则下一个节点就是父节点
             *     如果当前节点是一个右子树，根据“左根右” 则下一个节点是父节点的父节点
             */
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }
                pNode = pNode.next;
            }

            return null;
        }
    }
}
