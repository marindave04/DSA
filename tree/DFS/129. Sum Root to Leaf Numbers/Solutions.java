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
    static int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        int x=0;
        solve(root,x);
        return sum;
    }
    static void solve(TreeNode root,int x){
        if(root.left==null && root.right==null){
            x=root.val+x*10;
            sum=sum+x;
            return;
        }
        if(root.left!=null){
            solve(root.left,root.val+x*10);
        }
        if(root.right!=null){
            solve(root.right,root.val+x*10);
        }
    }
}
