/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **DFS + Graph Coloring (2-coloring to check Bipartite)** | **O(V + E)**    | **O(V)**         |

*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        //basically it is a bipartite concept
        // we will use two colore red-1,green-0
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(graph,i,color,1)==false) return false;;
            }
        }
        return true;
    }
    static boolean dfs(int[][] adj,int u,int[] color,int currentColor){
        color[u]=currentColor;
        for(int v:adj[u]){
            if(color[v]==color[u]) return false;
            if(color[v]==-1){
                color[v]=(int)Math.abs(1-currentColor);
                if(dfs(adj,v,color,color[v])==false) return false;
            }
        }
        return true;
    }
}
