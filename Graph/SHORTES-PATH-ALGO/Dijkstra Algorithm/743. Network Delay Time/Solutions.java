/*
| Approach                                                                            | Time Complexity      | Space Complexity |
| ----------------------------------------------------------------------------------- | -------------------- | ---------------- |
| Build directed graph + apply Dijkstra (min-heap) from source `k`, take max distance | **O((V + E) log V)** | **O(V + E)**     |

*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Making adjency list
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:times){
            int u=row[0];
            int v=row[1];
            int w=row[2];
            adj.get(u).add(new int[]{v,w});
        }
        int[] result=new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int dist=curr[0];
            int node=curr[1];
            if(dist>result[node]) continue;
            for(int[] neigh:adj.get(node)){
                int v=neigh[0];
                int w=neigh[1];
                if(dist+w<result[v]){
                    result[v]=dist+w;
                    pq.offer(new int[]{result[v],v});
                }
            }
        }
        int min=0;
        for(int i=1;i<n+1;i++){
            if(result[i]==Integer.MAX_VALUE) return -1;
            min=Math.max(min,result[i]);
        }
        return min;
    }
}
