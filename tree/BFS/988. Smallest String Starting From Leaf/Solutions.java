/*
| Approach                                                               | Time Complexity        | Space Complexity |
| ---------------------------------------------------------------------- | ---------------------- | ---------------- |
| **BFS (Store path strings in queue + reverse at leaf + sort results)** | **O(n * h + k log k)** | **O(n * h)**     |

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
    public String smallestFromLeaf(TreeNode root) {
    ArrayList<String> list=new ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    Queue<String> q1=new LinkedList<>();
    q.offer(root);
    q1.offer(""+(char)(root.val+'a'));
    while(!q.isEmpty()){
        int lsize=q.size();
        for(int i=0;i<lsize;i++){
            TreeNode curr=q.poll();
            String sb=q1.poll();
            if(curr.left==null && curr.right==null){
                 StringBuilder s=new StringBuilder(sb);
                 s.reverse();
                 list.add(s.toString());
            }
            if(curr.left!=null){
                q.offer(curr.left);
                char ch=(char)(curr.left.val+'a');
                
                q1.offer(sb+ch);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                char ch=(char)(curr.right.val+'a');
               
                q1.offer(sb+ch);
            }
        }
    }
    Collections.sort(list);
    return list.get(0);
    }
}
