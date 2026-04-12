public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {

            // दोनों left में हैं
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // दोनों right में हैं
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // split point
            else {
                return root;
            }
        }
        return null;
    }
}
