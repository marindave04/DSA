/*
| Approach                                                                      | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS on Tree + Greedy (Subtree sum modulo k to count divisible components)** | **O(n)**        | **O(n)**         |

*/
class Solution {
    static int count;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        count=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    dfs(adj,0,-1,values,k);
    return count;
    }
    static int dfs(ArrayList<ArrayList<Integer>> adj,int u,int parent,int[] values,int k){
        long sum=(long)values[u];
        for(int v:adj.get(u)){
            if(v!=parent){
                sum+=dfs(adj,v,u,values,k);
                sum=(sum%k);
            }
        }
          sum=(sum%k);
          if(sum==0){
            count++;
            return 0;
          }
          return (int)sum;
    }
}
