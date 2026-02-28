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
                if(bfs(adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean bfs( ArrayList<ArrayList<Integer>>  adj,int u,int parent, boolean[] visited){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{u,-1});
        visited[u]=true;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            u=pair[0];
            parent=pair[1];
            for(int v:adj.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(new int[]{v,u});
                }else  if(visited[v]){
                    if(v!=parent){
                        return true;
                    }
                }
               
            }
        }
        return false;
    }
}
