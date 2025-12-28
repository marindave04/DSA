class Solution {
    public int countNegatives(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int count=0;
       if(grid[m-1][n-1]>=0) return 0;
       if(grid[0][0]<0) return m*n;
       for(int i=0;i<m;i++){
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(grid[i][mid]<0){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
       if(ans!=-1){
        count=count+(n-ans);
       }
       } 
       return count;
    }
}