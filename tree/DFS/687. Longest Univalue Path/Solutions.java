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
    static int ans;
    public int longestUnivaluePath(TreeNode root) {
       ans=0;
       solve(root);
       return ans;
    }
    static int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        int leftPath=0;
        int rightPath=0;
        if(root.left!=null && root.val==root.left.val){
            leftPath=left+1;
        }
        if(root.right!=null && root.val==root.right.val){
            rightPath=right+1;
        }
        ans=Math.max(ans,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }
}
