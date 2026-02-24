// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are identical
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not, trees are not identical
        if (p == null || q == null) {
            return false;
        }

        // If values differ, trees are not identical
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}