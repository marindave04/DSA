/*
| Approach                                                                              | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS + Recursion Stack + Depth Tracking (Cycle length detection in directed graph)** | **O(V + E)**    | **O(V)**         |

*/

class Solution {
    static int max;
    public int longestCycle(int V, int[][] edges) {
        // code here
        //Make adj list
        max=-1;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[V];
        boolean[] ir=new boolean[V];
        int[] count=new int [V];
        Arrays.fill(count,1);
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,ir,count);
            }
        }
        return max;
    }
    static void dfs(int u, ArrayList<ArrayList<Integer>> adj,boolean[] visited,  boolean[] ir,int[] count){
        visited[u]=true;
        ir[u]=true;
        for(int v:adj.get(u)){
            if(visited[v] && ir[v]){
                int len=(int)Math.abs(count[u]-count[v]+1);
                max=Math.max(max,len);
             
            }
           if(!visited[v]){
               count[v]=count[u]+1;
                dfs(v,adj,visited,ir,count);
           }
        }
        ir[u]=false;
    }
}
