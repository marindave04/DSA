/*
| Approach                                                           | Time Complexity | Space Complexity |
| ------------------------------------------------------------------ | --------------- | ---------------- |
| **DFS Traversal to find Connected Components in Undirected Graph** | **O(V + E)**    | **O(V)**         |

*/
class Solution {
   
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> list= new ArrayList<>();
                dfs(adj,i,visited,list);
                ans.add(list);
            }
        }
        return ans;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited,  ArrayList<Integer> list){
        visited[u]=true;
        list.add(u);
        for(int v:adj.get(u)){
            if(!visited[v]){
                  dfs(adj,v,visited,list);
            }
        }
    }
}
