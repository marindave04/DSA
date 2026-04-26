/*
| Approach                                                                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse each cell, run DFS on same-character neighbors while tracking previous cell to detect revisiting (cycle) | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    static int m;
    static int n;
    static int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
    public boolean containsCycle(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                  if(!visited[i][j]){
                      if(dfs(grid,i,j,visited,i,j)){
                        return true;
                    }
                  }
            }
        }
        return false;
    }
    static boolean dfs(char[][] grid,int i,int j,boolean[][] visited,int x,int y){
            if(visited[i][j]) return true;
            visited[i][j]=true;
            for(int[] dir:directions){
                int new_i=i+dir[0];
                int new_j=j+dir[1];
                if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && grid[new_i][new_j]==grid[i][j]){
                    if(new_i==x && new_j==y) continue;
                    if(dfs(grid,new_i,new_j,visited,i,j)){
                        return true;
                    }
                }
            }
            return false;
    }
}
