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
    static int dia=0;
    static int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
         solve(root);
         return max;
    }
    static int solve(TreeNode root){
        if(root==null) return -1;
       
        int l=solve(root.left);
        int r=solve(root.right);
        int height=Math.max(l,r)+1;
        dia=l+r+2;
        max=Math.max(max,dia);
        return height;
    }
}
//Actual Approach
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
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        solve(root);
        return ans;
    }
    static int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        ans=Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}
