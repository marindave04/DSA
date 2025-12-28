class Solution {
    public int countNegatives(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int count=0;
       if(grid[m-1][n-1]>=0) return 0;
       if(grid[0][0]<0) return m*n;
       int row=m-1;
       int col=0;
       while(row>=0 && col<n){
        if(grid[row][col]>=0){
            col++;
        }else{
            count+=n-col;
            row--;
        }
       }
       return count;
    }
}