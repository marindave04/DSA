/*
| Approach                                    | Time Complexity | Space Complexity |
| ------------------------------------------- | --------------- | ---------------- |
| **Multi-source BFS (from all water cells)** | **O(m × n)**    | **O(m × n)**     |

*/

class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int[][] highestPeak(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) grid[i][j]=0;
                else grid[i][j]=-1;
            }
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==-1){
                        grid[new_i][new_j]=grid[i][j]+1;
                        q.offer(new int[]{new_i,new_j});
                    }
                }
            }
        }
        return grid;
   } 
}
