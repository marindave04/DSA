/*
| Approach                                                  | Time Complexity | Space Complexity |
| --------------------------------------------------------- | --------------- | ---------------- |
| **Hashing + DFS (Build Tree using Parent-Child Mapping)** | **O(n)**        | **O(n)**         |

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children=new HashSet<>();
        HashSet<Integer> parent=new HashSet<>();
        HashMap<Integer,List<int[]>> parent_to_child=new HashMap<>();
        for(int[] row:descriptions){
            int parent_i=row[0];
            int child_i=row[1];
            int isLeft_i=row[2];
            children.add(child_i);
            parent.add(parent_i);
            parent_to_child.computeIfAbsent(parent_i,k->new ArrayList<>()).add(new int[]{child_i,isLeft_i});
        }
        parent.removeAll(children);
        TreeNode root=new TreeNode(parent.iterator().next());
        return dfs(root,parent_to_child);
       
    }
    static TreeNode dfs(TreeNode root,HashMap<Integer,List<int[]>> map){
        if(root==null){
            return null;
        }
        for(int[] info:map.getOrDefault(root.val,Collections.emptyList())){
            int child=info[0];
            int dir=info[1];
            if(dir==1){
                root.left=dfs(new TreeNode(child),map);
            }else if(dir==0){
                root.right=dfs(new TreeNode(child),map);
            }
        }
        return root;
    }
}
/*
| Approach                                     | Time Complexity | Space Complexity |
| -------------------------------------------- | --------------- | ---------------- |
| **HashMap (Node Mapping) + Set (Find Root)** | **O(n)**        | **O(n)**         |

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
    public TreeNode createBinaryTree(int[][] d) {
        HashMap<Integer,TreeNode> nodeMap=new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for(int[] row:d){
            int parent=row[0];
            int child=row[1];
            int isLeft=row[2];
            if(!nodeMap.containsKey(parent)){
                nodeMap.put(parent,new TreeNode(parent));
            }
            if(!nodeMap.containsKey(child)){
                nodeMap.put(child,new TreeNode(child));
            }
            if(isLeft==1){
                nodeMap.get(parent).left=nodeMap.get(child);
            }else{
                nodeMap.get(parent).right=nodeMap.get(child);
            }
            children.add(child);
        }
        for(TreeNode node:nodeMap.values()){
            if(!children.contains(node.val)) return node;
        }
        return null;
    }
}
