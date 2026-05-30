/*
| Approach                                                                                                                       | Time               | Space        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------ | ------------ |
| Try removing each edge from last to first, rebuild the graph, then check whether the remaining graph is connected and acyclic. | **O(E · (V + E))** | **O(V + E)** |

*/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int i=n-1;
        while(i>=0){
            int x=edges[i][0];
            int y=edges[i][1];
            ArrayList<Integer>[] adj=new ArrayList[n+1];
            for(int p=0;p<n+1;p++){
                adj[p]=new ArrayList<>();
            }
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int u=edges[j][0];
                int v=edges[j][1];
                adj[u].add(v);
                adj[v].add(u);
            }
            if(!isCyclic(adj,n) && isConnected(adj,n)) return new int[]{x,y};
            i--;
        }
        return new int[]{};
    }
    static boolean isCyclic(ArrayList<Integer>[] adj,int n){
        boolean[] visited=new boolean[n+1];
        if(dfs(adj,visited,1,-1)) return true;
        return false;
    }
    static boolean dfs(ArrayList<Integer>[] adj,boolean[] visited,int u,int parent){
        visited[u]=true;
        for(int v:adj[u]){
            if(parent==v) continue;
            if(visited[v]) return true;
            if(!visited[v]){
                if(dfs(adj,visited,v,u)) return true;
            }
        }
        return false;
    }
    static boolean isConnected(ArrayList<Integer>[] adj,int n){
       HashSet<Integer> set=new HashSet<>();
        boolean[] visited=new boolean[n+1];
        dfs2(adj,visited,1,set);
        if(set.size()==n) return true;
        return false;
    }
    static void dfs2(ArrayList<Integer>[] adj,boolean[] visited,int u,HashSet<Integer> set){
        visited[u]=true;
        set.add(u);
         for(int v:adj[u]){
            if(!visited[v]){
                dfs2(adj,visited,v,set);
            }
        }
    }
}
