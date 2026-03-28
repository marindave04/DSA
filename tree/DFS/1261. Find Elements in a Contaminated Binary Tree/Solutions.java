/*
| Approach                                         | Time Complexity        | Space Complexity |
| ------------------------------------------------ | ---------------------- | ---------------- |
| **DFS Reconstruction + HashSet for O(1) lookup** | **O(n) + O(1) ≈ O(n)** | **O(n)**         |

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
class FindElements {
     TreeNode root;
     HashSet<Integer> set=new HashSet<>();
    public FindElements(TreeNode root) { 
        this.root=root;
        root.val=0;
        dfs(root);
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        set.add(root.val);
       if(root.left!=null) root.left.val=root.val*2+1;
        dfs(root.left);
         if(root.right!=null)root.right.val=root.val*2+2;
         dfs(root.right);
        
    }
    public boolean find(int target) {
        if(set.contains(target)) return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
