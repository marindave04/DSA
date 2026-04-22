/*
| Approach                                                                            | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Build graph (adj list) + BFS traversal to check path from source to destination** | **O(V + E)**    | **O(V + E)**     |

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
        Queue<Integer> q=new LinkedList<>();
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==destination) return true;
            for(int v:adj.get(curr)){
                if(!visited[v]){
                    q.offer(v);
                    visited[v]=true;
                }
            }
        }
        return false;
    }
}
