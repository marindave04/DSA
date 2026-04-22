/*
| Approach                                                                                         | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------ | --------------- | ---------------- |
| **Find height (DFS) → then DFS again to get first node at deepest level (left-first traversal)** | **O(n)**        | **O(h)**         |

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
    static int ans;
    static boolean flag;
    public int findBottomLeftValue(TreeNode root) {
        ans=0;
        flag=false;
       int height=solve(root);
        dfs(root,height,0);
        return ans;
    }
    static void dfs(TreeNode root,int height,int level){
        if(root==null) return;
        if(level==height && !flag){
            ans=root.val;
            flag=true;
        }
        dfs(root.left,height,level+1);
        dfs(root.right,height,level+1);
    }
    static int solve(TreeNode root){
        if(root==null) return -1;
        int l=solve(root.left);
        int r=solve(root.right);
        return Math.max(l,r)+1;
    }
}
