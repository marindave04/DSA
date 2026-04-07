/*
| Approach                                                        | Time Complexity | Space Complexity |
| --------------------------------------------------------------- | --------------- | ---------------- |
| **BFS from every Land Cell (Boundary Detection per Component)** | **O((m × n)²)** | **O(m × n)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(bfs(grid,i,j)==false){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    static boolean bfs(int[][] grid,int r,int c){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c]=true;
        while(!q.isEmpty()){
            int lsize=q.size();
             for(int p=0;p<lsize;p++){
                int[] curr=q.poll();
                int i=curr[0];
                int j=curr[1];
                for(int[] dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i<0 || new_i>=m || new_j<0 || new_j>=n){
                        return true;
                    }
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==1 && !visited[new_i][new_j]){
                      visited[new_i][new_j]=true;
                      q.offer(new int[]{new_i,new_j});
                    }
                }
            }
        }
        return false;
    }
}
/*
| Approach                                                   | Time Complexity | Space Complexity |
| ---------------------------------------------------------- | --------------- | ---------------- |
| **Multi-Source BFS from Boundary (Remove Reachable Land)** | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                 if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(grid[i][j]==1){
                        q.offer(new int[]{i,j});
                        grid[i][j]=0;
                    }
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
                   
                    if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==1){
                     grid[new_i][new_j]=0;
                      q.offer(new int[]{new_i,new_j});
                    }
                }
            }
        }
        int count=0;
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
   
}
