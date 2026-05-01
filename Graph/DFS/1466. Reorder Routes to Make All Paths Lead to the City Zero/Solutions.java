/*
| Approach                                                                                                                                                                            | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Store original directed roads in HashSet, convert graph to undirected adjacency list, DFS from city `0`, and count edges whose original direction goes away from DFS traversal path | **O(n)**        | **O(n)**         |

*/
class Solution {
    static int count;
    static HashSet<String> set;
    public int minReorder(int n, int[][] connections) {
        //Making adj list
        count=0;
        set=new HashSet<>();
        for(int[] row:connections){
            int u=row[0];
            int v=row[1];
            String str=u+"_"+v;
            set.add(str);
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:connections){
            int u=row[0];
            int v=row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        dfs(adj,visited,0);
        return count;
    }
   static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int u){
    visited[u]=true;
    for(int v:adj.get(u)){
        if(!visited[v]){
            String str=u+"_"+v;
        if(set.contains(str)){
            count++;
        }
            dfs(adj,visited,v);
        }
    }
   }
}
