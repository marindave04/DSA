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
/*
| Approach                                                                                              | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Pick root from postorder end, find its position in inorder, recursively build right then left subtree | **O(n²)**       | **O(n)**         |

*/
class Solution {
    static int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         idx=postorder.length-1;
         return solve(0,inorder.length-1,inorder,postorder);
    }
    static TreeNode solve(int s,int e,int[] in,int[] po){
        if(s>e || idx<0) return null;
        TreeNode root=new TreeNode (po[idx--]);
        if(s==e) return root;
        int j=s;
        while(in[j]!=root.val){
            j++;
        }
        root.right=solve(j+1,e,in,po);
        root.left=solve(s,j-1,in,po);
        return root;
    }
}
/*
| Approach                                                                                             | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Use postorder from end for root, hashmap for inorder index, recursively build right and left subtree | **O(n)**        | **O(n)**         |

*/
class Solution {
    static int idx;
    static HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         idx=postorder.length-1;
         map=new HashMap<>();
         for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
         }
         return solve(0,inorder.length-1,inorder,postorder);
    }
    static TreeNode solve(int s,int e,int[] in,int[] po){
        if(s>e || idx<0) return null;
        TreeNode root=new TreeNode (po[idx--]);
        if(s==e) return root;
        int j=map.get(root.val);
        root.right=solve(j+1,e,in,po);
        root.left=solve(s,j-1,in,po);
        return root;
    }
}
