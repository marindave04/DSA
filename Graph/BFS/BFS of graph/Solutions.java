class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean[] visited = new boolean[n];
         ArrayList<Integer> list=new ArrayList<>();
         BFS(adj,0,visited,list);
         return list;
    }
    static void BFS(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited, ArrayList<Integer> list){
        Queue<Integer> q= new LinkedList<>();
        q.offer(u);
        list.add(u);
        visited[u]=true;
        while(!q.isEmpty()){
            u=q.poll();
            for(int v:adj.get(u)){
                if(!visited[v]){
                    q.add(v);
                    visited[v]=true;
                    list.add(v);
                }
            }
        }
    }
}
