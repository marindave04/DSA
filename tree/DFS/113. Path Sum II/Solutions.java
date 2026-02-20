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
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     if(root==null) return ans;
     List<Integer> list=new ArrayList<>();
     solve(root,0,targetSum,list);
     return ans;
    }
    private void solve(TreeNode root,int sum,int target,List<Integer> list){
     
        if(root.left==null && root.right==null){
            sum=sum+root.val;
            list.add(root.val);
            if(sum==target){

                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
             list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        if(root.left!=null)solve(root.left,sum+root.val,target,list);
        if(root.right!=null) solve(root.right,sum+root.val,target,list);
        list.remove(list.size()-1);
    }
}
