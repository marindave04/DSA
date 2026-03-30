/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **BFS (level order) + Minimum swaps to sort each level** | **O(n log n)**  | **O(n)**         |

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
    public int minimumOperations(TreeNode root) {
        //we will be using concept of bfs and min swap req to sort arrays
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int swap=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            int[] nums=new int[lsize];
            int[] sorted=new int[lsize];
            for(int i=0;i<lsize;i++){
                TreeNode curr=q.poll();
                nums[i]=curr.val;
                sorted[i]=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            Arrays.sort(sorted);
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=sorted[i]){
                    swap++;
                    int idx1=map.get(nums[i]);
                    int idx2=map.get(sorted[i]);
                    map.put(nums[i],map.get(sorted[i]));
                    map.put(sorted[i],map.get(nums[i]));
                    int temp=nums[idx1];
                    nums[idx1]=nums[idx2];
                    nums[idx2]=temp;
                }
            }
        }
        return swap;
    }
}
