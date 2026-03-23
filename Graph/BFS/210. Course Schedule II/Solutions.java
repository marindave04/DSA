/*
| Approach                                                         | Time Complexity | Space Complexity |
| ---------------------------------------------------------------- | --------------- | ---------------- |
| **Kahn’s Algorithm (BFS Topological Sort to find course order)** | **O(V + E)**    | **O(V + E)**     |

*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Make adj list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
        }
       //populating indegree
       int[] indegree=new int[numCourses];
       for(int i=0;i<adj.size();i++){
        for(int v:adj.get(i)){
            indegree[v]++;
        }
       }
       //using kahns algo and bfs
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0){
            q.offer(i);
        }
       }
       int[] ans=new int[numCourses];
       int idx=0;
       int total=0;
       while(!q.isEmpty()){
        int u=q.poll();
        total++;
        ans[idx++]=u;
        for(int v:adj.get(u)){
            indegree[v]--;
            if(indegree[v]==0){
                q.offer(v);
            }
        }
       }
       if(total==ans.length) return ans;
       return new int[]{};
    }
}
