class Solution {
    static int[][] t=new int[2501][2501]; 
    public int lengthOfLIS(int[] nums) {
        for(int i=0;i<2501;i++){
            for(int j=0;j<2501;j++){
                t[i][j]=-2;
            }
        }
        return solve(nums,0,-1);
    }
    static int solve(int[]nums,int i,int p){
        if(i>=nums.length) return 0;
        if(p!=-1&&t[i][p]!=-2) return t[i][p];
        int take=0;
        
        if(p==-1 || nums[i]>nums[p]){
           
            take=1+solve(nums,i+1,i);
        }
         
        int skip=solve(nums,i+1,p);
        if(p!=-1) {
            return t[i][p]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}