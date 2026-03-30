/*
| Approach                                                       | Time Complexity | Space Complexity                               |
| -------------------------------------------------------------- | --------------- | ---------------------------------------------- |
| **DFS Traversal (Flood Fill using recursion in 4 directions)** | **O(m · n)**    | **O(m · n)** *(recursion stack in worst case)* |

*/
class Solution {
    static int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int original=grid[sr][sc];
        if(original==color) return grid;
        dfs(grid,sr,sc,color,original);
        return grid;
    }
    static void dfs(int[][] grid, int sr, int sc, int color,int original){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length) return;
         if(grid[sr][sc]!=original) return;
         grid[sr][sc]=color;
        
        for(int[] dir:directions){
            int new_sr=sr+dir[0];
            int new_sc=sc+dir[1];
            dfs(grid,new_sr,new_sc,color,original);
        }
    }
}
