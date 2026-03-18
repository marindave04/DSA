/*
| Approach                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS + TreeMap (HD mapping) + Sorting by level & value for Vertical Traversal** | **O(n log n)**  | **O(n)**         |

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
           // code here
        TreeMap<Integer,List<List<Integer>>> map=new TreeMap<>();
        solve(root,0,0,map);
         List<List<Integer>> ans=new ArrayList<>();
         for(int hd:map.keySet()){
            List<List<Integer>> temp=map.get(hd);
            Collections.sort(temp,Comparator.comparingInt((List<Integer>a)->a.get(1)).thenComparingInt(a->a.get(0)));
            List<Integer> list=new ArrayList<>();
            for( List<Integer> t:temp){
                list.add(t.get(0));
            }
            ans.add(list);
         }
         return ans;
    }
     static void solve(TreeNode root,int hd,int lvl ,  TreeMap<Integer,List<List<Integer>>> map){
        if(root==null) return;
        List<List<Integer>> lines= map.getOrDefault(hd,new ArrayList<>());
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        list.add(lvl);
        lines.add(list);
        map.put(hd,lines);
       
        solve(root.left,hd-1,lvl+1,map);
        solve(root.right,hd+1,lvl+1,map);
    }
}
