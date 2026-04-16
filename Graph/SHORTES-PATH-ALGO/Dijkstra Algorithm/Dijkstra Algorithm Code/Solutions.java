/*
| Approach                                             | Time Complexity      | Space Complexity |
| ---------------------------------------------------- | -------------------- | ---------------- |
| **Dijkstra’s Algorithm (Min Heap + Adjacency List)** | **O((V + E) log V)** | **O(V + E)**     |

*/
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        //Make ADJENCY LIST
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int[] result=new int[V];
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        result[src]=0;
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int dist=curr[1];
            if(dist>result[u]) continue;
            for(int[] neigh:adj.get(u)){
                int node=neigh[0];
                int d=neigh[1];
                if(dist+d<result[node]){
                    result[node]=dist+d;
                    pq.offer(new int[]{node,dist+d});
                }
            }
        }
        return result;
    }
}
