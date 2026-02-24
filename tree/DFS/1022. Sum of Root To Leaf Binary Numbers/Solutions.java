//APPROACH-1 TC O(N) AND SC O(N);
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
    public int sumRootToLeaf(TreeNode root) {
         ArrayList<String> list=new ArrayList<>();
         solve(root,"",list);
         int sum=0;
         for(String str:list){
            int decimal=Integer.parseInt(str,2);
            sum+=decimal;
         }
         return sum;
    }
    static void solve(TreeNode root,String s, ArrayList<String> list){
        if(root.left==null && root.right==null){
            s=s+root.val;
            list.add(s);
            return;
        }
        int val=root.val;
        s=s+val;
        if(root.left!=null)solve(root.left,s,list);
        if(root.right!=null)solve(root.right,s,list);
    }
}
//APPROACH -2 TC-O(N) AND SC-(1)
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
    
    public int sumRootToLeaf(TreeNode root) {
      return solve(root,0);
    }
    static int solve(TreeNode root,int sum){
        if(root==null) return 0;
        sum=2*sum+root.val;
        if(root.left==null && root.right==null) return sum;
        int left=solve(root.left,sum);
        int right=solve(root.right,sum);
        return left+right;
    }
}
