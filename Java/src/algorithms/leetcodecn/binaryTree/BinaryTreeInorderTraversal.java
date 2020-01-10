package algorithms.leetcodecn.binaryTree;

/**
 * Created by thpffcj on 2019/10/20.
 */

import algorithms.leetcodecn.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.add(current);
                stack.add(current.left);
            } else {
                result.add(current.val);
                if (!stack.isEmpty()) {
                    TreeNode temp = stack.pop();
                    temp.left = null;
                    stack.add(temp);
                }
                if (current.right != null) {
                    stack.add(current.right);
                }
            }
        }

        return result;
    }

    public List <Integer> inorderTraversal2(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List <Integer> inorderTraversal3(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }

            res.add(root.val);

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public List <Integer> inorderTraversal4(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal i = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        i.inorderTraversal(root);
    }
}
