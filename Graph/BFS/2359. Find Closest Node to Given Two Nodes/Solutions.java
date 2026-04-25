/*
| Approach                                                                                                               | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| For every node, run BFS from `node1` and `node2` to compute reachable distances, choose node with minimum max distance | **O(n²)**       | **O(n)**         |

*/
class Solution {
    static int n;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //mke adj list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        n=edges.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
           if(edges[i]!=-1) adj.get(i).add(edges[i]);
        }
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int a=bfs(adj,node1,i);
            int b=bfs(adj,node2,i);
            if(a!=-1 && b!=-1){
                int max=Math.max(a,b);
                if(max<min){
                    min=max;
                    ans=i;
                }
            }
        }
        return ans==-1 ? -1 : ans;
    }
    static int bfs(ArrayList<ArrayList<Integer>> adj,int src,int target){
          boolean[] visited=new boolean[n];
          Queue<Integer> q=new LinkedList<>();
          q.offer(src);
          visited[src]=true;
          int dis=0;
          int max=-1;
          while(!q.isEmpty()){
              int u=q.poll();
              if(u==target){
               return dis;
              }
              for(int v:adj.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
              }
              dis++;
          }
          return -1;
    }
}
