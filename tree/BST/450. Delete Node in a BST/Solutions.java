/*
| Approach                                                                                                                                                       | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Perform inorder traversal excluding target key to get sorted values, then rebuild a balanced BST recursively from the sorted list using middle element as root | **O(n)**        | **O(n)**         |

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
    public TreeNode deleteNode(TreeNode root, int key) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list,key);
        return solve(list,0,list.size()-1);
    }
    static void inorder(TreeNode root,ArrayList<Integer> list,int key){
        if(root==null) return;
        inorder(root.left,list,key);
        if(root.val!=key) list.add(root.val);
        inorder(root.right,list,key);
    }
    static TreeNode solve(ArrayList<Integer> list,int s,int e){
        if(s>e) return null;
        int mid=s+(e-s)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=solve(list,s,mid-1);
        root.right=solve(list,mid+1,e);
        return root;
    }
}
