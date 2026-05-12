/*
| Approach                                                                                                                               | Time                | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------- | ------------------- | -------- |
| Use Disjoint Set Union (Union-Find) with path compression and union by rank; if two vertices already have same parent, a cycle exists. | **O(V + E · α(V))** | **O(V)** |

*/
class Solution {
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] parent=new int[V];
        int[] rank=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                if(u<v){
                    int parent_u=find(u,parent);
                    int parent_v=find(v,parent);
                    if(parent_u==parent_v) return true;
                    else union(u,v,parent,rank);
                }
            }
        }
        return false;
    }
    static int find(int i,int[]parent){
        if(i==parent[i]) return i;
        return parent[i]=find(parent[i],parent);
    }
    static void union(int x,int y,int[] parent,int[]rank){
        int x_parent=find(x,parent);
        int y_parent=find(y,parent);
        if(x_parent==y_parent) return;
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }else if(rank[x_parent]<rank[y_parent]){
              parent[x_parent]=y_parent;
        }else{
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }
}
