/*
Approach
Current:
Depth-First Search
/
Recursion
/
Brute-Force Search
  */
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
    private int total=0;
    public int pathSum(TreeNode root, int targetSum) {
         if(root==null) return 0;
        solve(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum); 
        return total;
    }
    private void solve(TreeNode root,int target,long sum){
        if(root==null) return;
        sum=(long)sum+root.val;
        if(sum==target) total++;
        solve(root.left,target,sum);
        solve(root.right,target,sum);
    }
}
