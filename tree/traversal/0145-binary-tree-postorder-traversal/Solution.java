// LeetCode 145: Binary Tree Postorder Traversal
// Approach: DFS (Recursive)
// Time: O(n)
// Space: O(h)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> list=new ArrayList<>();
        solve(root,list);
        return list;
    }
     static void solve(TreeNode root,List<Integer> list){
        if(root==null) return;
        
        solve(root.left,list);
        solve(root.right,list);
        list.add(root.val);
    }
}
