/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **DFS + Distance Propagation (Bottom-Up Pair Counting)** | **O(N × D²)**   | **O(N)**         |

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
    public int countPairs(TreeNode root, int distance) {
      int[] ans=new int[1];
      dfs(root,distance,ans);
      return ans[0];
    }
   static ArrayList<Integer> dfs(TreeNode root, int distance,int[] ans){
       if(root==null){
         ArrayList<Integer> list1=new ArrayList<>();
         list1.add(0);
         return list1;
       }
       if(root.left==null && root.right==null){ //leaf node found
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(1);
        return list2;
       }
       ArrayList<Integer> left=dfs(root.left,distance,ans);
       ArrayList<Integer> right=dfs(root.right,distance,ans);
       for(int l:left){
        for(int r:right){
            if(l!=0 && r!=0 && (l+r)<=distance){
                ans[0]++;
            }
        }
       }
        ArrayList<Integer> combine=new ArrayList<>();
        for(int l:left){
            if(l!=0 && l+1<=distance){
                combine.add(l+1);
            }
        }
        for(int r:right){
            if(r!=0 && r+1<=distance){
                combine.add(r+1);
            }
        }
        return combine;
   }
}
