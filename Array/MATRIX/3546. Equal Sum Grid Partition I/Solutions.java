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
