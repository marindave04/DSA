/*
| Approach                                                           | Time Complexity | Space Complexity |
| ------------------------------------------------------------------ | --------------- | ---------------- |
| **BFS Traversal to find Connected Components in Undirected Graph** | **O(V + E)**    | **O(V)**         |

*/
class Solution {
   
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> list= new ArrayList<>();
                bfs(adj,i,visited,list);
                ans.add(list);
            }
        }
        return ans;
    }
    static void bfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visited,  ArrayList<Integer> list){
       Queue<Integer> q=new LinkedList<>();
       q.offer(u);
       visited[u]=true;
       list.add(u);
       while(!q.isEmpty()){
           u=q.poll();
          
           for(int v:adj.get(u)){
               if(!visited[v]){
                   q.offer(v);
                   list.add(v);
                visited[v]=true;
               }
           }
       }
    }
}
