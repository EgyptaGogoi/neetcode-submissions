/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getHeight(TreeNode root){
        if(root == null)
            return 0;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

       if (Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) &&
               isBalanced(root.right);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna