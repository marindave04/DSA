//BRUTE FORCE

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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        solve(root,list);
        return list.get(k-1);
    }
    static void solve(TreeNode root, ArrayList<Integer> list){
        if(root==null) return ;

        solve(root.left,list);
        list.add(root.val);
        solve(root.right,list);
    }
}

//OPTIMAL

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
    static int count;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        return solve(root,k).val;
    }
    static TreeNode solve(TreeNode root,int k){
        if(root==null) return null;

       TreeNode left=solve(root.left,k);
       if(left!=null) return left;
       count++;
       if(count==k) return root;
       return solve(root.right,k);
    }
}
