/*| Complexity Type      | Value                    | Reason                                             |
| -------------------- | ------------------------ | -------------------------------------------------- |
| **Time Complexity**  | **O(n²)**                | Matrix traversal (`n × n`) to build adjacency list |
| **DFS Time**         | **O(V + E)** ≈ **O(n²)** | Worst case me sab nodes connected                  |
| **Space Complexity** | **O(n²)**                | Adjacency list storage                             |
| **Auxiliary Space**  | **O(n)**                 | `visited[]` + recursion stack                      |
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        //adj list;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(isConnected[i][j]==1){
                    int u=i;
                    int v=j;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
    static void dfs(  ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfs(adj,v,visited);
            }
        }
    }
}

/*
| Complexity Type      | Value     | Reason                                              |
| -------------------- | --------- | --------------------------------------------------- |
| **Time Complexity**  | **O(n²)** | Har node ke liye poori matrix traverse ho sakti hai |
| **Space Complexity** | **O(n)**  | `visited[]` array                                   |
| **Auxiliary Space**  | **O(n)**  | DFS recursion stack                                 |

*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
       
       
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
    static void dfs(int[][] isConnected ,int u, boolean[] visited){
        visited[u]=true;
        for(int v=0;v<isConnected.length;v++){
            if(!visited[v]&&isConnected[u][v]==1){
                dfs(isConnected,v,visited);
            }
        }
    }
}
