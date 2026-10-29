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
    private int maxDia = 0;

    public int calDia( TreeNode root){
        if (root == null)
            return 0;
        
        int left = calDia(root.left);
        int right = calDia(root.right);

        maxDia = Math.max(maxDia, left + right);

        return 1+ Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calDia(root);
        return maxDia;
    }
}