/*| Approach                                                                                                                      | Time         | Space        |
| ----------------------------------------------------------------------------------------------------------------------------- | ------------ | ------------ |
| Use BFS level-by-level (each level = one stop) with cost relaxation to find the minimum flight cost within at most `k` stops. | **O(K · E)** | **O(N + E)** |
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adj[u].add(new int[]{v,w});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});
        int level=0;
        while(!q.isEmpty() && level<=k){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
            int[] curr=q.poll();
            int u=curr[0];
            int d=curr[1];
            for(int[] neigh:adj[u]){
                int v=neigh[0];
                int w=neigh[1];
                if(d+w<dist[v]){
                    dist[v]=d+w;
                    q.offer(new int[]{v,dist[v]});
                }
            }
            }
            level++;
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
