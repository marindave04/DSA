class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         int[] indegree=new int[V];
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
         //populate indegree array
         for(int u=0;u<V;u++){
             for(int v:adj.get(u)){
                 indegree[v]++;
             }
         }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.offer(i);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        //simply bfs
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        return ans;
    }
}
