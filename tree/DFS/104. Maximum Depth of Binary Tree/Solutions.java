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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
       int nodes=solve(root)+1;
       return nodes;
    }
    static int solve(TreeNode root){
         if(root==null) return -1;
        int l=solve(root.left);
        int r=solve(root.right);
        
        return Math.max(l,r)+1;
    }
}
