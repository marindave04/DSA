/*
| Type  | Complexity |
| ----- | ---------- |
| Time  | **O(n)**   |
| Space | **O(n)**   |

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
     Stack<TreeNode> st=new Stack<>();
     for(int i=0;i<nums.length;i++){
        TreeNode curr=new TreeNode(nums[i]);
        while(!st.isEmpty() && st.peek().val<nums[i]){
            curr.left=st.pop();
        }
        if(!st.isEmpty()){
            st.peek().right=curr;
        }
        st.push(curr);
     }
     return st.firstElement();
    }
}
