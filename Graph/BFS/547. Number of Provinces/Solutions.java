/*
| Approach                                                                        | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------- | --------------- | ---------------- |
| **BFS Traversal on Adjacency Matrix to count connected components (Provinces)** | **O(n²)**       | **O(n)**         |

*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
       
       
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
    static void bfs(int[][] isConnected ,int u, boolean[] visited){
       Queue<Integer> q=new LinkedList<>();
       q.offer(u);
       visited[u]=true;
       while(!q.isEmpty()){
        u=q.poll();
        for(int v=0;v<isConnected.length;v++){
            if(!visited[v] && isConnected[u][v]==1){
              q.offer(v);
              visited[v]=true;
            }
        }
       }
    }
}
