//Brute Force
//TC AND SC IS O(N)
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
    public void flatten(TreeNode root) {
        if(root==null) return;
     Queue<TreeNode> q=new LinkedList<>();
     solve(root,q);
     root=q.poll();
     Queue<TreeNode> p=new LinkedList<>();
     p.offer(root);
     while(!q.isEmpty()){
        TreeNode node=p.poll();
        
        //left child;
        node.left=null;
        //right child
        if(!q.isEmpty()){
            TreeNode temp=q.poll();
            node.right=temp;
            p.offer(temp);
        }
     }
    }
    static void solve(TreeNode root, Queue<TreeNode> q){
        if(root==null) return;
        q.offer(root);
        solve(root.left,q);
        solve(root.right,q);
    }
}
//OPTIMAL
// TC O(N) & SC (1)
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
    public void flatten(TreeNode root) {
      if(root==null) return;
      TreeNode curr=root;
      while(curr!=null){
       if(curr.left!=null){
        TreeNode temp=curr.left;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=curr.right;
        curr.right=curr.left;
        curr.left=null;
       }
       curr=curr.right;
      }
    }
}
