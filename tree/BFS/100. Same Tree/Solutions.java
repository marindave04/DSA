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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        q1.offer(p);
        q2.offer(q);
        boolean flag=true;
        while(!q1.isEmpty() && !q2.isEmpty()){
            int lsize1=q1.size();
            int lsize2=q2.size();
            if(lsize1!=lsize2) return false;
            for(int i=0;i<lsize1;i++){
                TreeNode node1=q1.poll();
                TreeNode node2=q2.poll();
                if((node1.left==null && node2.left==null) && (node1.right==null && node2.right==null) ) continue;
                 if((node1.left==null && node2.left !=null) || (node1.left!=null && node2.left ==null)) return false;
                if((node1.right!=null && node2.right==null) || (node1.right==null && node2.right!=null)) return false;
               
                if(node1.left!=null && node2.left!=null){
                    if(node1.left.val==node2.left.val){
                    flag=true;
                }else{
                    return false;
                }
                }
                if(node1.right!=null && node2.right!=null){
                    if(node1.right.val==node2.right.val){
                    flag=true;
                }else{
                    return false;
                }
                }
                if(node1.left!=null){
                    q1.add(node1.left);
                    
                }
                if(node1.right!=null){
                    q1.add(node1.right);
                }
                if(node2.left!=null){
                    q2.add(node2.left);
                    
                }
                if(node2.right!=null){
                    q2.add(node2.right);
                }
            }
        }
        return flag;
    }
}
