/*
| Approach                                                                        | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------- | --------------- | ---------------- |
| **DFS + Topological Sort (using Stack) with Cycle Detection (Recursion Stack)** | **O(V + E)**    | **O(V)**         |

*/
class Solution {
    public int[] findOrder(int V, int[][] p) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int u=p[i][1];
            int v=p[i][0];
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[V];
        boolean[] ir=new boolean[V];
        Stack<Integer> st=new Stack<>();
         int[] ans=new int[V];
        if(isCycle(V,adj,visited,ir,st)){
            return new int[]{};
        }else{
          
            for(int i=0;i<V;i++){
                ans[i]=st.pop();
            }
        }
        return ans;
    }
    boolean isCycle(int V, ArrayList<ArrayList<Integer>>adj, boolean[] visited,  boolean[] ir, Stack<Integer> st){
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,ir,st)) return true;
            }
        }
        return false;
    }
    boolean dfs(int u, ArrayList<ArrayList<Integer>>adj, boolean[] visited,  boolean[] ir, Stack<Integer> st){
        visited[u]=true;
        ir[u]=true;
        for(int v:adj.get(u)){
            if(visited[v] && ir[v]) return true;
            if(!visited[v]){
                if(dfs(v,adj,visited,ir,st)) return true;
            }
        }
        st.push(u);
        ir[u]=false;
        return false;
    }
}
