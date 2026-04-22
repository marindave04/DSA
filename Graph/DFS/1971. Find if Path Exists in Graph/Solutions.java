/*
| Approach                                                                          | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Build graph (adj list) + DFS to check reachability from source to destination** | **O(V + E)**    | **O(V + E)**     |

*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
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
        boolean[] visited =new boolean[n];
        return dfs(adj,visited,source,destination);
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int src,int target){
        visited[src]=true;
        for(int v:adj.get(src)){
            if(!visited[v]){
                if(v==target) return true;
                if(dfs(adj,visited,v,target)) return true;
            }
        }
        return false;
    }
}
