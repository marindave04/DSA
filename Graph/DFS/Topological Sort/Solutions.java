class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         boolean[] visited=new boolean[V];
         Stack<Integer> st=new Stack<>();
         // Make adjency list
         for(int i=0;i<V;i++){
             adj.add(new ArrayList<>());
         }
         for(int i=0;i<edges.length;i++){
             int u=edges[i][0];
             int v=edges[i][1];
             adj.get(u).add(v);
         }
         for(int i=0;i<V;i++){
             if(!visited[i]){
                 dfs(adj,i,visited,st);
             }
         }
         ArrayList<Integer> ans=new ArrayList<>();
         while(!st.isEmpty()){
             int x=st.pop();
             ans.add(x);
         }
         return ans;
    }
    static void dfs( ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited, Stack<Integer> st){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfs(adj,v,visited,st);
            }
        }
        st.add(u);
    }
}
