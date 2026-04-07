/*
| Approach                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------- | --------------- | ---------------- |
| **Tree → Graph + BFS from each Leaf Node (Distance Limited BFS)** | **O(L × N)**    | **O(N)**         |

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
    public int countPairs(TreeNode root, int distance) {
        //since we need to run bfs from each leafNodes so we need to convert tree into undirected graph and then run bfs from each leafNode to calculte shortes distance between any two leafNodes
       HashMap<TreeNode,ArrayList<TreeNode>> adj=new HashMap<>();
       HashSet<TreeNode> leafNodes=new HashSet<>();
       //Making adj list and storing leafNodes
       solve(root,null,adj,leafNodes);
       //Now implementing BFS on each leafNode
       int ans=0;
       for(TreeNode leaf:leafNodes){
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        visited.add(leaf);
        q.offer(leaf);
        //now visiting all nodes upto distance dist==distance
        for(int i=0;i<=distance;i++){
            int n=q.size();
            for(int j=0;j<n;j++){
                TreeNode curr=q.remove();
                if(leafNodes.contains(curr) && curr!=leaf){
                    ans++;
                }
                if(adj.containsKey(curr)){
                    for(TreeNode neighbor:adj.get(curr)){
                        if(!visited.contains(neighbor)){
                            q.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
       }
       return ans/2;
    }
    static void solve(TreeNode curr,TreeNode prev,HashMap<TreeNode,ArrayList<TreeNode>> adj,HashSet<TreeNode> leafNodes){
        if(curr==null) return;
        if(curr.left==null && curr.right==null){
            leafNodes.add(curr);
        }
        if(prev!=null){
            adj.computeIfAbsent(prev,k->new ArrayList<TreeNode>());
            adj.get(prev).add(curr);
            adj.computeIfAbsent(curr,k->new ArrayList<TreeNode>());
            adj.get(curr).add(prev);
        }
        solve(curr.left,curr,adj,leafNodes);
        solve(curr.right,curr,adj,leafNodes);
    }
}
