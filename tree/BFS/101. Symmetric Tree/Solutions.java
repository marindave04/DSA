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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        if(root.left.val==root.right.val){
            q.offer(root.left);
            q.offer(root.right);
        }else{
            return false;
        }
        boolean flag=false;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n/2;i++){
                TreeNode left=q.poll();
                TreeNode right=q.poll();
                 if(left==null && right==null) continue;
                if(left==null || right==null) return false;
               
                if(left.val==right.val){
                    flag=true;
                }else {
                    return false;
                }
                if((left.left==null && right.right==null) || (left.right==null && right.left==null)){
                    if(left.left!=null) q.add(left.left);
              if(right.right!=null) q.add(right.right);
              if(left.right!=null) q.add(left.right);
              if(right.left!=null) q.add(right.left);
              continue;
                }
                if(left.left==null || right.right==null) return false;
                  if(left.right==null || right.left==null) return false;
              if(left.left!=null) q.add(left.left);
              if(right.right!=null) q.add(right.right);
              if(left.right!=null) q.add(left.right);
              if(right.left!=null) q.add(right.left);
              
            }
        }
        return flag;
    }
}
