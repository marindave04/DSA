/*
| Approach                                                     | Time Complexity        | Space Complexity |
| ------------------------------------------------------------ | ---------------------- | ---------------- |
| **DFS (Build all leaf→root strings + sort to get smallest)** | **O(n * h + k log k)** | **O(n * h)**     |

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
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> list=solve(root);
        Collections.sort(list);
        return list.get(0);
    }
    static ArrayList<String> solve(TreeNode root){
        if(root.left==null && root.right==null){
            char ch=(char)(root.val+'a');
            StringBuilder sb=new StringBuilder();
            sb.append(ch);
            ArrayList<String> base=new ArrayList<>();
            base.add(sb.toString());
            return base;
        }
         ArrayList<String> left=new ArrayList<>();
          ArrayList<String> right=new ArrayList<>();
          if(root.left!=null){
            left=solve(root.left);
          }

          if(root.right!=null){
            right=solve(root.right);
          }
          char ch2=(char)(root.val+'a');
          ArrayList<String> ans=new ArrayList<>();
          for(String s:left){
            ans.add(s+ch2);
          }
          for(String s:right){
            ans.add(s+ch2);
          }
          return ans;
    }
}
