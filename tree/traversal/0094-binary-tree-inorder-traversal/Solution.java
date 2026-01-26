// LeetCode 94: Binary Tree Inorder Traversal
// Approach: DFS (Recursive)
// Time: O(n)
// Space: O(h)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list=new ArrayList<>();
        solve(root,list);
        return list;
    }
    static void solve(TreeNode root,List<Integer> list){
        if(root==null) return;
       
        solve(root.left,list);
         list.add(root.val);
        solve(root.right,list);
    }
}
