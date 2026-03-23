/*
| Approach                                                      | Time Complexity | Space Complexity |
| ------------------------------------------------------------- | --------------- | ---------------- |
| **DFS + Recursion Stack (Cycle Detection in Directed Graph)** | **O(V + E)**    | **O(V)**         |

*/
class Solution {
    public boolean canFinish(int V, int[][] p) {
        //cycle detection using dfs that includes concept of detecting cycle in a directed graph using inrecursion concept
        //Make adj list
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int u=p[i][1];
            int v=p[i][0];
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[V];
        boolean[] ir=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,ir)) return false;
            }
        }
        return true;
    }
    static boolean dfs(int u,ArrayList<ArrayList<Integer>>adj, boolean[] visited, boolean[] ir){
        visited[u]=true;
        ir[u]=true;
        for(int v:adj.get(u)){
            if(visited[v] && ir[v]) return true;
            if(!visited[v]){
                if(dfs(v,adj,visited,ir)) return true;
            }
        }
        ir[u]=false;
        return false;
    }
}
