/*
| Approach                                                                | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------- | --------------- | ---------------- |
| **Level order traversal (BFS) + validate parity & order at each level** | **O(n)**        | **O(n)**         |

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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            int[] nums=new int[lsize];
            for(int i=0;i<lsize;i++){
                 TreeNode curr=q.poll();
                 nums[i]=curr.val;
                 if(curr.left!=null){
                    q.add(curr.left);
                 }
                 if(curr.right!=null){
                    q.add(curr.right);
                 }
            }
            if(level%2==0){
                if(!checkOddInc(nums)){
                    return false;
                }
            }else{
                if(!checkEvenDec(nums)){
                    return false;
                }
            }
            level++;
        }
        return true;
    }
    static boolean checkOddInc(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;
    }
     static boolean checkEvenDec(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]) return false;
        }
        return true;
    }
}
/*
| Approach                                                               | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------- | --------------- | ---------------- |
| **BFS level traversal with on-the-fly validation (parity + ordering)** | **O(n)**        | **O(n)**         |

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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            int prev=-1;
            for(int i=0;i<lsize;i++){
                 TreeNode curr=q.poll();
                 int x=curr.val;
                 
                 if(level%2==0){
                   if(x%2==0) return false;
                   if(prev==-1){
                    prev=x;
                   }else{
                    if(x<=prev) return false;
                    prev=x;
                   }
                 }else{
                    if(x%2!=0) return false;
                    if(prev==-1){
                        prev=x;
                    }else{
                        if(x>=prev) return false;
                        prev=x;
                    }
                 }
                 if(curr.left!=null){
                    q.add(curr.left);
                 }
                 if(curr.right!=null){
                    q.add(curr.right);
                 }
            }
            level++;
        }
        return true;
    }
}
