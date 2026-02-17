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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] idx=new int[]{postorder.length-1};
        return solve(inorder,postorder,idx,0,inorder.length-1);
    }
    static TreeNode solve(int[] in,int[] post,int[] idx,int s,int e){
        if(s>e || idx[0]<0) return null;
        TreeNode root=new TreeNode(post[idx[0]--]);
        int pos=s;
        while(pos<=e && in[pos]!=root.val){
            pos++;
        }
        root.right=solve(in,post,idx,pos+1,e);
        root.left=solve(in,post,idx,s,pos-1);
      return root;
    }
}
