// Time Complexity -> O(n);
//Space Complexity ->O(n);
class Solution {
    public TreeNode successor(TreeNode root) {
      
         Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            
          
            TreeNode curr=q.poll();
           
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
            if(curr==root) break;
          
        }
        return q.peek();
    }
}
