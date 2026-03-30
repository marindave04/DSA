/*
| Approach                                                   | Time Complexity | Space Complexity |
| ---------------------------------------------------------- | --------------- | ---------------- |
| **BFS Traversal (Flood Fill using queue in 4 directions)** | **O(m · n)**    | **O(m · n)**     |

*/
class Solution {
    static int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int original=grid[sr][sc];
        if(original==color) return grid;
        bfs(grid,sr,sc,color,original);
        return grid;
    }
    static void bfs(int[][] matrix, int sr, int sc, int color,int original){
       Queue<int[]> q=new LinkedList<>();
       q.offer(new int[]{sr,sc});
       while(!q.isEmpty()){
           int lsize=q.size();
           for(int i=0;i<lsize;i++){
            int[] curr=q.poll();
            sr=curr[0];
            sc=curr[1];
            if(matrix[sr][sc]==original){
                matrix[sr][sc]=color;
                for(int[] dir:directions){
            int new_sr=sr+dir[0];
            int new_sc=sc+dir[1];
            if( new_sr>=0 && new_sc>=0 && new_sr<matrix.length && new_sc<matrix[0].length){
                 q.offer(new int[]{ new_sr,new_sc});
            }
           
        }
            }
             
        
           }
       }
    }
}
