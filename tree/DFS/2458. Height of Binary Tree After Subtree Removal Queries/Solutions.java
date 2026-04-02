/*
| Approach                                                                | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------- | --------------- | ---------------- |
| **Brute Force DFS for each query (recompute height excluding subtree)** | **O(q × n)**    | **O(h)**         |

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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int h=solve(root,queries[i]);
            ans[i]=h;
        }
        return ans;
    }
    static int solve(TreeNode root,int target){
        if(root==null) return -1;
        if(root.val==target) return -1;
        int l=solve(root.left,target);
        int r=solve(root.right,target);
        return (int)Math.max(l,r)+1;
    }
}
/*
| Approach                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------- | --------------- | ---------------- |
| **Two DFS Traversals (Left→Right & Right→Left) + Precomputation** | **O(n + q)**    | **O(n)**         |

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
    //storing height of tree after removing each node;
    static int[] heights=new int[100001];
    static int max;
    public int[] treeQueries(TreeNode root, int[] queries) {
        max=0;
        //traversing left to right 
        leftToRight(root,0);
        max=0;
        rightToLeft(root,0);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=heights[queries[i]];
        }
        return ans;
    }
    static void leftToRight(TreeNode root,int dis){
        if(root==null) return;
        heights[root.val]=max;
        max=Math.max(max,dis);
        leftToRight(root.left,dis+1);
        leftToRight(root.right,dis+1);
    }
    static void  rightToLeft(TreeNode root,int dis){
        if(root==null) return;
        heights[root.val]=Math.max(max,heights[root.val]);
        max=Math.max(max,dis);
        rightToLeft(root.right,dis+1);
        rightToLeft(root.left,dis+1);
    }
}
