/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **Multi-source BFS (level-wise rotting spread in grid)** | **O(m · n)**    | **O(m · n)**     |

*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int min=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==1){
                        grid[new_i][new_j]=2;
                        fresh--;
                        q.offer(new int[]{new_i,new_j});
                    }
                }

            }
            min++;
        }
        if(fresh==0) return min-1;
        return -1;
    }
}
