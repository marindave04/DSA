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
/*
| Approach                                            | Time Complexity | Space Complexity |
| --------------------------------------------------- | --------------- | ---------------- |
| **Single DFS + Level-wise Top 2 Heights (Optimal)** | **O(n + q)**    | **O(n)**         |

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
    //storing height of each node
    private int[] heights=new int[100001];
    //storing level of each node
    private int[] levels=new int[100001];
    //storing max of each level
    private int[] levelMax=new int[100001];
    //storing 2nd max of each level
    private int[] levelSecondMax=new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
       //populating each declared data structures
       
       solve(root,0);
       int m=queries.length;
       int[] ans=new int[m];
       for(int i=0;i<m;i++){
         int node = queries[i];
            int h = heights[node];
            int l = levels[node];

            int best = (h == levelMax[l]) ? levelSecondMax[l] : levelMax[l];
            ans[i] = l + best - 1;
       }
       return ans;
    }
    private int solve(TreeNode root,int level){
        if(root==null) return 0;
        levels[root.val]=level;
        int l=solve(root.left,level+1);
        int r=solve(root.right,level+1);
        heights[root.val]=Math.max(l,r)+1;
        if(levelMax[level]< heights[root.val]){
            levelSecondMax[level]=levelMax[level];
            levelMax[level]=heights[root.val];
        }else if(levelSecondMax[level]<heights[root.val]){
             levelSecondMax[level]=heights[root.val];
        }
        return  heights[root.val];
    }
}
