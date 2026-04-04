/*
| Approach                                               | Time Complexity | Space Complexity |
| ------------------------------------------------------ | --------------- | ---------------- |
| **Two BFS Traversals (Level Sum + Value Replacement)** | **O(n)**        | **O(n)**         |

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
    public TreeNode replaceValueInTree(TreeNode root) {
         ArrayList<Integer> levelSum=new ArrayList<>();
         
         bfs(root,levelSum);
         Queue<TreeNode> q=new LinkedList<>();
         q.offer(root);
         root.val=0;
         int idx=1;
         while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                TreeNode curr=q.poll();
                int lsum=idx<levelSum.size()?levelSum.get(idx) : 0;
                int siblingSum=(curr.left!=null ? curr.left.val : 0) + (curr.right!=null ? curr.right.val : 0);
                if(curr.left!=null){
                    curr.left.val=lsum- siblingSum;
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val=lsum- siblingSum;
                    q.offer(curr.right);
                }
            }
            idx++;
         }
         return root;
    }
    static void bfs(TreeNode root,ArrayList<Integer> levelSum){
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);
      
       while(!q.isEmpty()){
           int lsize=q.size();
           int sum=0;
           for(int i=0;i<lsize;i++){
              TreeNode curr=q.poll();
              sum+=curr.val;
              if(curr.left!=null){
                q.add(curr.left);
               
              }
              if(curr.right!=null){
                q.add(curr.right);
              }
           }
          levelSum.add(sum);
       }
    }
}
