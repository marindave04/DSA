class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        int[] nums=new int[n];
        long sum=(long)n*(n+1)/2;
        if(target<-sum || target>sum || ((sum-target)%2==1)){
            return new int[0];
        }
        int count=0;
       for(int i=n;i>=1;i--){
        count++;
        int a=-i;
        long t=target-(long)a;
        long sum2=(long)(n-count)*(n-count+1)/2;
        if (t >= -sum2 && t <= sum2 && (sum2 - t) % 2 == 0){
            nums[i-1]=a;
        }else{
            nums[i-1]=-a;
        }
        target=target-nums[i-1];
       }
       Arrays.sort(nums);
       return nums;
    }
}