class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[n];
        dfs(adj,0,visited,list);
        return list;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited, ArrayList<Integer> list){
        if(visited[u]) return;
        visited[u]=true;
        list.add(u);
        for(int v:adj.get(u)){
            if(!visited[v]){
                  dfs(adj,v,visited,list);
            }
        }
    }
}
