/*
| Approach                                          | Time Complexity | Space Complexity |
| ------------------------------------------------- | --------------- | ---------------- |
| **Two DFS Traversals (Level Sum + Value Update)** | **O(n)**        | **O(n)**         |

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
    static int[] levelSum=new int[100000];
    public TreeNode replaceValueInTree(TreeNode root) {
        Arrays.fill(levelSum,0);
         
         dfs(root,0);
         dfs2(root,0);
          root.val=0;
        return root;
    }
    static void dfs(TreeNode root,int level){
        if(root==null) return;
        levelSum[level]=levelSum[level]+root.val;
        dfs(root.left,level+1);
        dfs(root.right,level+1);
       
    }
     static int dfs2(TreeNode root,int level){
        if(root==null) return 0;
       
        int l=dfs2(root.left,level+1);
        int r=dfs2(root.right,level+1);
        int sum=l+r;
        if(root.left!=null)root.left.val=levelSum[level+1]-sum;
        if(root.right!=null)root.right.val=levelSum[level+1]-sum;
        return root.val;
    }
}
