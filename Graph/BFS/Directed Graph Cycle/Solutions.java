/*
| Component                  | Complexity   | Reason                                               |
| -------------------------- | ------------ | ---------------------------------------------------- |
| Adjacency list banana      | **O(V + E)** | V lists create + E edges add                         |
| Indegree calculate karna   | **O(V + E)** | Har vertex aur uski adjacency traverse               |
| Queue processing (BFS)     | **O(V + E)** | Har node ek baar queue me + har edge ek baar process |
| **Total Time Complexity**  | **O(V + E)** | Graph traversal overall                              |
| Adjacency list space       | **O(V + E)** | V lists + E edges                                    |
| Indegree array             | **O(V)**     | Ek array of size V                                   |
| Queue                      | **O(V)**     | Worst case me saare vertices                         |
| **Total Space Complexity** | **O(V + E)** | Dominant adjacency list                              |

*/
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //Make adjency list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        int[] indegree=new int[V];
        //populate indegree
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
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
        if(total==V) return false;
        return true;
    }
}
