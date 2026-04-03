/*
| Approach                               | Time Complexity | Space Complexity |
| -------------------------------------- | --------------- | ---------------- |
| **Level-order BFS with flip handling** | **O(n)**        | **O(n)**         |

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while(!q1.isEmpty() && !q2.isEmpty()){
            int l1=q1.size();
            int l2=q2.size();
            if(l1!=l2) return false;
           
            for(int i=0;i<l1;i++){
                TreeNode curr1=q1.poll();
                TreeNode curr2=q2.poll();
                int left1=-1;
                int right1=-1;
                int left2=-1;
                int right2=-1;
                // evaluating childs
               
                if(curr1.left!=null){
                    left1=curr1.left.val;
                    q1.offer(curr1.left);
                }
                if(curr1.right!=null){
                    right1=curr1.right.val;
                     q1.offer(curr1.right);
                }
                 if(curr2.left!=null){
                    left2=curr2.left.val;
                   
                }
                if(curr2.right!=null){
                    right2=curr2.right.val;
                    
                }
                
                if((left1==left2 && right1==right2)){
                    //means swap never happend
                      if(curr2.left!=null){
                    q2.offer(curr2.left);
                   
                }
                if(curr2.right!=null){
                  q2.offer(curr2.right);
                    
                }
                }else if(left1==right2 && left2==right1){
                    //swap happend
                     if(curr2.right!=null){
                   q2.offer(curr2.right);
                    
                }
                  if(curr2.left!=null){
                    q2.offer(curr2.left);
                   
                }
                }else{
                    return false;
                }
            }
            
        }
        return true;
    }
   
}
