/*
| Approach                                                                                               | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------ | --------------- | ---------------- |
| **Simulation of Horizontal & Vertical Cuts (with reverse + transpose) + HashSet for adjustment check** | **O(m · n)**    | **O(m · n)**     |

*/
class Solution {
    static long total;
    public boolean canPartitionGrid(int[][] grid) {
        total=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=grid[i][j];
            }
        }
        //horzontal cut
        if(h(grid)) return true;
        reverse(grid);
        if(h(grid)) return true;
        //vertical cut will get handle through transpose of a matrix
        reverse(grid);
        int[][] transpose=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                transpose[j][i]=grid[i][j];
            }
        }
         if(h(transpose)) return true;
        reverse(transpose);
        if(h(transpose)) return true;
        return false;
    }
    static void reverse(int[][] grid){
        int top=0;
        int bottom=grid.length-1;
        while(top<=bottom){
            int[] temp=grid[top];
            grid[top]=grid[bottom];
            grid[bottom]=temp;
            top++;
            bottom--;
        }
    }
   static boolean h(int[][] grid){
         int m=grid.length;
        int n=grid[0].length;
        HashSet<Long> st=new HashSet<>();
        long top=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                st.add((long)grid[i][j]);
                top=(long)top+grid[i][j];

            }
            long bottom=(long) total-top;
            long diff=(long) top-bottom;
            if(diff==0) return true;
            if((long)grid[0][0]==diff) return true;
            if((long)grid[0][n-1]==diff) return true;
            if((long)grid[i][0]==diff) return true;
            if(i>0 && n>1 && st.contains(diff)) return true;
        }
        return false;
    }
}
