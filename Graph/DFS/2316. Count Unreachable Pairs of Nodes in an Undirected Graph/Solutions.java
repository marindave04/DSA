/*
| Approach                                                                                                                                                 | Time Complexity                                                                      | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------ | ---------------- |
| Build undirected graph, use DFS to find sizes of all connected components, then count unreachable pairs by multiplying sizes of every pair of components | **O(n²)** worst case *(due to pairwise component multiplication)* + **O(n + e)** DFS | **O(n + e)**     |

*/
class Solution {
    public long countPairs(int n, int[][] edges) {
        long temp=(long)n*(n-1)/2;
        if(edges.length==0){
           return temp;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:edges){
            int u=row[0];
            int v=row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                HashSet<Integer> set=new HashSet<>();
                dfs(adj,i,set,visited);
                  list.add(set.size());
            }
          
        }
        long ans=0;
        int x=list.size();
        for(int i=0;i<x-1;i++){
            for(int j=i+1;j<x;j++){
                ans=(long)ans+(long)list.get(i)*list.get(j);
            }
        }
        return ans;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int u,HashSet<Integer> set,boolean[] visited){
        visited[u]=true;
        set.add(u);
        for(int v:adj.get(u)){
            if(!visited[v]){
                 dfs(adj,v,set,visited);
            }
        }
    }
}
/*
| Approach                                                                                                                                                     | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------ | --------------- | ---------------- |
| Compute total possible node pairs `n(n-1)/2`, use DFS to find each connected component size, subtract internally reachable pairs `size(size-1)/2` from total | **O(n + e)**    | **O(n + e)**     |

*/
class Solution {
    public long countPairs(int n, int[][] edges) {
        long temp=(long)n*(n-1)/2;
        if(edges.length==0){
           return temp;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:edges){
            int u=row[0];
            int v=row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        ArrayList<Integer> list=new ArrayList<>();
        long temp2=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int[] count=new int[1];
                dfs(adj,i,count,visited);
                temp2=(long)temp2+(long)count[0]*(count[0]-1)/2;
            }
          
        }
        
        return temp-temp2;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int u,int[] count,boolean[] visited){
        visited[u]=true;
        count[0]++;
        for(int v:adj.get(u)){
            if(!visited[v]){
                 dfs(adj,v,count,visited);
            }
        }
    }
}
