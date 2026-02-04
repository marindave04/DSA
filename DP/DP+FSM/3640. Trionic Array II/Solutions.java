class Solution {
    static long[][] t=new long[100001][4];
    public long maxSumTrionic(int[] nums) {
         for (int i = 0; i < 100001; i++) {
            Arrays.fill(t[i], Long.MIN_VALUE);
        }
       return solve(nums,0,0);
    }
    static long solve(int[] nums,int i,int states){

        if(i>=nums.length) {
            if(states==3){
                return 0;
            }else{
                return Long.MIN_VALUE/2;
            }
        }
       if(t[i][states]!=Long.MIN_VALUE) return t[i][states];
        long take=Long.MIN_VALUE/2;
        long skip=Long.MIN_VALUE/2;

        if(states==0){
            skip=solve(nums,i+1,0);
        }
        if(states==3){
            take=nums[i];
        }
        if(i+1<nums.length){
            int curr=nums[i];
            int next=nums[i+1];
            if(states==0 && next>curr){
                take=Math.max(take,curr+solve(nums,i+1,1));
            }else if(states==1){
                if(next>curr){
                    take=Math.max(take,curr+solve(nums,i+1,1));
                }else if(next<curr){
                    take=Math.max(take,curr+solve(nums,i+1,2));
                }
            }else if(states==2){
                if(next<curr){
                      take=Math.max(take,curr+solve(nums,i+1,2));
                }else if(next>curr){
                      take=Math.max(take,curr+solve(nums,i+1,3));
                }
            }else if(states==3 && next>curr){
                 take=Math.max(take,curr+solve(nums,i+1,3));
            }
        }
    return t[i][states]=Math.max(take,skip);
    }
}
