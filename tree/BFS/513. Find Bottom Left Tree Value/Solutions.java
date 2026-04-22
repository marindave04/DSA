/*
| Approach                                                                                           | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Level order traversal (BFS), take first node of each level → last level’s first node is answer** | **O(n)**        | **O(n)**         |

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int ans=-1;
        while(!q.isEmpty()){
            int size=q.size();
            boolean top=false;
            for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
               if(!top){
                ans=curr.val;
                top=true;
               }
               if(curr.left!=null){
                q.offer(curr.left);
               }
               if(curr.right!=null){
                q.offer(curr.right);
               }
            }
        }
        return ans;
    }
}
/*
| Approach                                                                                    | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Level order (BFS), push right first then left → last processed node becomes bottom-left** | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int ans=-1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               TreeNode curr=q.poll();
               ans=curr.val;
                if(curr.right!=null){
                q.offer(curr.right);
               }
               if(curr.left!=null){
                q.offer(curr.left);
               }
              
            }
        }
        return ans;
    }
}
