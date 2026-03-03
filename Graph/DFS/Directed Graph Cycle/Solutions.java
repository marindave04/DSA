class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //Make adjency list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
          
        }
        //Make sure each node gets visited
        boolean[] visited=new boolean[V];
        boolean[] inRecursion=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,inRecursion)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs( ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited, boolean[] inRecursion){
        visited[u]=true;
        inRecursion[u]=true;
        for(int v:adj.get(u)){
            if(visited[v] && inRecursion[v]) return true;
            if(!visited[v]){
                if(dfs(adj,v,visited,inRecursion)) return true;
            }
        }
        inRecursion[u]=false;
        return false;
    }
}
