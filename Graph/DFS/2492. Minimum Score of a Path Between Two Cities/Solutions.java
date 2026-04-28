/*
| Approach                                                                                                                             | Time Complexity  | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------ | ---------------- | ---------------- |
| Build graph using adjacency list, DFS traverse all cities reachable from city `1`, and keep updating global minimum road weight seen | **O(n + roads)** | **O(n + roads)** |

*/
class Solution {
    static int ans;
    public int minScore(int n, int[][] roads) {
        //Making adj list
        ans=Integer.MAX_VALUE;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:roads){
            int u=row[0];
            int v=row[1];
            int w=row[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        boolean[] visited=new boolean[n+1];
       dfs(adj,1,n,Integer.MAX_VALUE,visited);
       return ans;
    }
    static void dfs(ArrayList<ArrayList<int[]>> adj,int src,int target,int min,  boolean[] visited){
        visited[src]=true;
        for(int[] nums:adj.get(src)){
            int v=nums[0];
            int w=nums[1];
            ans=Math.min(ans,w);
           if(!visited[v]){
             dfs(adj,v,target,min,visited);
           }
        }
       
    }
}
