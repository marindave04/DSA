/*
| Approach                                                                         | Time Complexity | Space Complexity             |
| -------------------------------------------------------------------------------- | --------------- | ---------------------------- |
| **Recursive DFS (Preorder reconstruction using depth tracking & index pointer)** | **O(n)**        | **O(h)** *(recursion stack)* |

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
    static int idx;
    public TreeNode recoverFromPreorder(String traversal) {
        idx=0;
        return solve(traversal,0);
    }
    static TreeNode solve(String s,int depth){
        if(idx>=s.length()) return null;
        int dash=0;
        int j=idx;
        while(j<s.length() && s.charAt(j)=='-'){
            j++;
        }
        dash=(j-idx);
        if(depth!=dash) return null;
        idx=idx+dash;
        int value=0;
        while(idx<s.length() && Character.isDigit(s.charAt(idx))){
           value=value*10+(s.charAt(idx)-'0');
           idx++;
        }
      //Make node
      TreeNode node=new TreeNode(value);
      node.left=solve(s,depth+1);
      node.right=solve(s,depth+1);
      return node;
    }
}
