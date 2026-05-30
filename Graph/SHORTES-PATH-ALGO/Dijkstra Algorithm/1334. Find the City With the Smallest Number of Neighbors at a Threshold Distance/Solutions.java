/*
| Approach                                                                                                                                                             | Time               | Space        |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------ | ------------ |
| Run Dijkstra's algorithm from every city, count reachable cities within the distance threshold, then choose the city with the minimum count (largest index on ties). | **O(N · E log N)** | **O(N + E)** |

*/
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }
        int[] srcCount=new int[n];
        for(int src=0;src<n;src++){
        int[] result=new int[n];
        Arrays.fill(result,distanceThreshold+1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        result[src]=0;
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[0];
            int dist=curr[1];
            if(dist>result[u] || dist>distanceThreshold) continue;
            for(int[] neigh:adj[u]){
                int node=neigh[0];
                int d=neigh[1];
                if(dist+d<result[node]){
                    result[node]=dist+d;
                    pq.offer(new int[]{node,dist+d});
                   
                }
            }
        }
        int count=0;
        for(int p=0;p<n;p++){
            if(result[p]==0 || result[p]==distanceThreshold+1) continue;
            else count++;
        }
        srcCount[src]=count;
        }
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            if(srcCount[i]<=min){
                min=srcCount[i];
                ans=i;
            }
        }
        return ans;
    }
}
