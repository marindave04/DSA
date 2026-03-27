/*
| Approach                                                                    | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------- | --------------- | ---------------- |
| **Row & Column Prefix Sum + Partition Check (Horizontal & Vertical split)** | **O(m · n)**    | **O(m + n)**     |

*/
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long[] vertical=new long[m];
        long[] horizontal=new long[n];
        for(int i=0;i<m;i++){
            long sum=0;
            for(int j=0;j<n;j++){
            sum=(long)sum+grid[i][j];
            }
            vertical[i]=sum;
        }
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=0;j<m;j++){
               sum=(long) sum + grid[j][i];
            }
            horizontal[i]=sum;
        }
        long[] pv=new long[m];
        long[] ph=new long[n];
        pv[0]=vertical[0];
        ph[0]=horizontal[0];
        for(int i=1;i<m;i++){
            pv[i]=(long)pv[i-1]+vertical[i];
        }
        for(int i=1;i<n;i++){
            ph[i]=(long)ph[i-1]+horizontal[i];
        }
        boolean flag=false;
        for(int i=0;i<m-1;i++ ){
          long sum1=pv[i];
          long sum2=pv[m-1]-pv[i];
          if(sum1==sum2) return true;
        }
        for(int i=0;i<n-1;i++ ){
          long sum1=ph[i];
          long sum2=ph[n-1]-ph[i];
          if(sum1==sum2) return true;
        }
        return false;
    }
}
/*
| Approach                                                       | Time Complexity | Space Complexity               |
| -------------------------------------------------------------- | --------------- | ------------------------------ |
| **Row-wise Prefix Sum Check + Transpose for column partition** | **O(m · n)**    | **O(n · m)** *(for transpose)* |

*/
class Solution {
    static long total;
    public boolean canPartitionGrid(int[][] grid) {
        total=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total=(long)total+grid[i][j];
            }
        }
      if(h(grid)) return true;
      int[][] transpose=new int[n][m];
      for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               transpose[j][i]=grid[i][j];
            }
        }
        if(h(transpose)) return true;
        return false;
    }
    static boolean h(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        long top=0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                top=(long)top+grid[i][j];
            }
            long bottom=(long) total -top;
            if(top==bottom) return true;
        }
        return false;
    }
}
