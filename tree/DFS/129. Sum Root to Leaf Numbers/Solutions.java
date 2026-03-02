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
//WITHOUT USING GLOBAL VARIABLE
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
  
    public int sumNumbers(TreeNode root) {
       
        int x=0;
       return solve(root,x);
        
    }
    static int solve(TreeNode root,int x){
        if(root.left==null && root.right==null){
            x=root.val+x*10;
          
            return x;
        }
        int left=0;
        int right=0;
        if(root.left!=null){
          left =  solve(root.left,root.val+x*10);
        }
        if(root.right!=null){
          right =  solve(root.right,root.val+x*10);
        }
        return left+right;
    }
}
