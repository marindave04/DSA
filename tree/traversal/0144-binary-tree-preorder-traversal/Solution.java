// LeetCode 144: Binary Tree Preorder Traversal
// Approach:  (Recursive)
// Time: O(n)
// Space: O(h)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        solve(root,list);
        return list;
    }
    static void solve(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        solve(root.left,list);
        solve(root.right,list);
    }
}
