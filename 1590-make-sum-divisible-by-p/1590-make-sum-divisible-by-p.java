class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+nums[i])%p;
        }
        int k=(sum%p);
        if(k==0) return 0;
        int[] psum=new int[n];
        psum[0]=nums[0];
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1]+nums[i];
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int temp=0;
        int ans=n;
        for(int i=0;i<n;i++){
           temp=(temp+nums[i])%p;
           int remain=(temp-k+p)%p;
           if(map.containsKey(remain)){
            ans=Math.min(ans,i-map.get(remain));
           }
           map.put(temp,i);
        }
        if(ans==n) return -1;
        return ans;
    }
}