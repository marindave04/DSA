/*
| Approach                                                                                           | Time Complexity      | Space Complexity |
| -------------------------------------------------------------------------------------------------- | -------------------- | ---------------- |
| Use Dijkstra with priority queue + parent array to store path, then backtrack from node `n` to `1` | **O((V + E) log V)** | **O(V + E)**     |

*/
class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here
        //Making adjency list
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        
            for (int i = 0; i <= n; i++) {
              adj.add(new ArrayList<>());
             }
        for(int[] row:edges){
            int u=row[0];
            int v=row[1];
            int w=row[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
         });
        pq.offer(new int[]{0,1});
        int[] result=new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[1]=0;
        int[] parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int d=curr[0];
            int u=curr[1];
            if(d>result[u]) continue;
            for(int[] neigh:adj.get(u)){
                int w=neigh[1];
                int node=neigh[0];
                if(d+w<result[node]){
                    result[node]=d+w;
                    parent[node]=u;
                    pq.offer(new int[]{result[node],node});
                }
            }
        }
      
          if (result[n] == Integer.MAX_VALUE) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }

        ArrayList<Integer> path=new ArrayList<>();
        int node = n;
        while(parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        path.add(result[n]);
        Collections.reverse(path);
        return path;
    }
}
