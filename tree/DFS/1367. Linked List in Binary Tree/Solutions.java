//TC-O(N*2*M)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return helper(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    static boolean helper(ListNode curr,TreeNode root){
        if(curr.next==null) return true;
        if(curr.next!=null && root==null) return false;
        boolean left=false;
        boolean right=false;
        int x=root.val;
        if(x==curr.val){
            if((root.left!=null) && (root.left.val==curr.next.val)){
               left=helper(curr.next,root.left);
            } 
            if((root.right!=null) && (root.right.val==curr.next.val)){
                right=helper(curr.next,root.right);
            }
        
            
        }else{
            left=helper(curr,root.left);
            right=helper(curr,root.right);
        }
        return (left || right);
    }
}
//TC=O(N*M)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return helper(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    static boolean helper(ListNode curr,TreeNode root){
       if(curr==null) return true;
       if(root==null) return false;
       if(curr.val!=root.val) return false;
       return helper(curr.next,root.left)||helper(curr.next,root.right);
    }
}
