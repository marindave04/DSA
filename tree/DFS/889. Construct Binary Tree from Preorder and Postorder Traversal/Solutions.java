/*
| Approach                                                                 | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------ | --------------- | ---------------- |
| Use preorder to pick root, find left subtree size via postorder, recurse | **O(n²)**       | **O(n)**         |

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        return solve(0,0,n-1,preorder,postorder);
    }
    static TreeNode solve(int preStart,int postStart,int preEnd,int[] pre,int[] post){
         if(preStart>preEnd) return null;
         TreeNode root=new TreeNode(pre[preStart]);
         if(preStart==preEnd) return root;
         int nextNode=pre[preStart+1];
         int j=postStart;
         while(post[j]!=nextNode){
            j++;
         }
         int num=j-postStart+1;
         root.left=solve(preStart+1,postStart,preStart+num,pre,post);
         root.right=solve(preStart+num+1,j+1,preEnd,pre,post);
         return root;
    }
}
