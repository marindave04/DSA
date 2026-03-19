/*
| Approach                                                                          | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Kahn’s Algorithm (BFS Topological Sort for Cycle Detection in Directed Graph)** | **O(V + E)**    | **O(V + E)**     |

*/
class Solution {
    public boolean canFinish(int V, int[][] p) {
        //cycle detection using bfs that includes concept of kanhs algo and topological sort
        //Make adj list
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int u=p[i][1];
            int v=p[i][0];
            adj.get(u).add(v);
        }
        //populating indegree
        int[] indegree=new int[V];
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        //putting that node in the queue whose indegree is zero
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int total=0;
        while(!q.isEmpty()){
            int u=q.poll();
            total++;
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        if(total==V) return true;
        return false;
    }
}
