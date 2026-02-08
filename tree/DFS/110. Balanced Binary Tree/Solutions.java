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
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag=true;
        solve(root);
        return flag;
    }
    static int solve(TreeNode root){
        if(root==null) return -1;

        int left=solve(root.left);
        int right=solve(root.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        return Math.max(left,right)+1;
    }
}
