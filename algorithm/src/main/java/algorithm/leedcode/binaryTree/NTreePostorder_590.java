package algorithm.leedcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * 关键是通过stack模拟递归调用
 */
public class NTreePostorder_590 {

    Stack<Node> stack = new Stack();

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.children == null || root.children.size() == 0) {
            list.add(root.val);
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.peek();

            if (currentNode.children != null && currentNode.children.size() > 0) {
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.push(currentNode.children.get(i));
                }
            }


            if (currentNode.children == null || currentNode.children.size() == 0) {
                list.add(stack.pop().val);
            }

            currentNode.children = null;
        }

        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

    }
};
