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
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        solve(root);
        return ans;
    }
    static int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        ans=Math.max(ans,left+right+root.val);
        int temp= root.val+Math.max(left,right);
        if(temp<0 ) return 0;
        return temp;
    }
}
