/*
| Approach                                               | Time Complexity        | Space Complexity |
| ------------------------------------------------------ | ---------------------- | ---------------- |
| **BFS Reconstruction of Tree + BFS Search for target** | **O(n) + O(n) ≈ O(n)** | **O(n)**         |

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
    public FindElements(TreeNode root) { 
        this.root=root;
         Queue<TreeNode> q2=new LinkedList<>();
         root.val=0;
         q2.offer(root);
         while(!q2.isEmpty()){
            int lsize=q2.size();
            for(int i=0;i<lsize;i++){
                TreeNode curr=q2.poll();
                int x=curr.val;
                if(curr.left!=null){
                    curr.left.val=2*x+1;
                    
                    q2.offer(curr.left);
                }
                if(curr.right!=null){
                    
                    curr.right.val=2*x+2;
                    q2.offer(curr.right);
                }
            }
         }
    }
    
    public boolean find(int target) {
         Queue<TreeNode> q=new LinkedList<>();
         q.offer(root);
             while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                TreeNode curr=q.poll();
                if(target==curr.val) return true;
                if(curr.left!=null){
                  
                    
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    
                   
                    q.offer(curr.right);
                }
            }
         }
         return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

/*
| Approach                                         | Time Complexity        | Space Complexity |
| ------------------------------------------------ | ---------------------- | ---------------- |
| **BFS Reconstruction + HashSet for O(1) lookup** | **O(n) + O(1) ≈ O(n)** | **O(n)**         |

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
         Queue<TreeNode> q2=new LinkedList<>();
         root.val=0;
         q2.offer(root);
         while(!q2.isEmpty()){
            int lsize=q2.size();
            for(int i=0;i<lsize;i++){
                TreeNode curr=q2.poll();
                int x=curr.val;
                set.add(x);
                if(curr.left!=null){
                    curr.left.val=2*x+1;
                    
                    q2.offer(curr.left);
                }
                if(curr.right!=null){
                    
                    curr.right.val=2*x+2;
                    q2.offer(curr.right);
                }
            }
         }
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
