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
    public TreeNode balanceBST(TreeNode root) {
        // EK LIST CREATE KRENGE JISME BST KE NODES SORTED FORM ME STROE KRENGE AUR WO INORDER TRAVERSAL KRTA HAI

        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return solve(list,0,list.size()-1);
    }
    private void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private TreeNode solve(List<Integer> list,int s,int e){
        if(s>e) return null;
        int mid=s+(e-s)/2;
        TreeNode left=solve(list,s,mid-1);
        TreeNode right=solve(list,mid+1,e);
        TreeNode node=new TreeNode(list.get(mid),left,right);
        return node;
    }
}
