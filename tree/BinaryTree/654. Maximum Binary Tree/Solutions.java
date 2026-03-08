//Approach-1
/*
| Case                          | Time Complexity | Space Complexity | Reason                                                                                                               |
| ----------------------------- | --------------- | ---------------- | -------------------------------------------------------------------------------------------------------------------- |
| **Best Case (Balanced tree)** | **O(n log n)**  | **O(log n)**     | Har recursion me array ka max find karne ke liye O(n) scan aur tree balanced hone ki wajah se height log n hoti hai. |
| **Worst Case (Sorted array)** | **O(n²)**       | **O(n)**         | Har step par almost pura array scan hota hai aur tree skewed ban jata hai (height n).                                |
| **Average Case**              | **O(n log n)**  | **O(log n)**     | Generally tree moderately balanced rehta hai.                                                                        |

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       int n=nums.length;
       return solve(nums,0,n-1);
    }
    static TreeNode  solve(int[] nums,int s,int e){
        if(s>e) return null;
        int r=-1;
        int max=Integer.MIN_VALUE;
        for(int i=s;i<=e;i++){
            if(nums[i]>max){
                max=nums[i];
                r=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left = solve(nums,s,r-1);
        root.right = solve(nums,r+1,e);
        return root;
    }
}
