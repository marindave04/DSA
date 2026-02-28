class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        //Make adjency list first;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:edges){
            int u=row[0];
            int v=row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //SINCE GRAPH CAN HAVE MULTIPLE COMPONENT SO WE NEED TO VISIT EACH NODE;
          boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs( ArrayList<ArrayList<Integer>>  adj,int u,int parent, boolean[] visited){
        visited[u]=true;
        for(int v:adj.get(u)){
            
            if(parent==v) continue;
            if(visited[v]==true) return true;
            if(dfs(adj,v,u,visited)==true) return true;
        }
        return false;
    }
}
