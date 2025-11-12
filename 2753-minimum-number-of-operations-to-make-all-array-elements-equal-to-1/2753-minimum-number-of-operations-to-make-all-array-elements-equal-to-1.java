class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1)count1++;
            
        }
        if(count1>0) return n-count1;
        int min=Integer.MAX_VALUE;
        int op=-1;
        for(int i=0;i<n-1;i++){
        if(nums[i]==1 && nums[i+1]==1) continue;
        int current=nums[i];
        for(int j=i+1;j<n;j++){
            current=gcd(current,nums[j]);
            if(current==1){
                op=j-i+(n-1);
                break;
            }
        }
        min=Math.min(min,op);
       }
       return min;
    }
   
    static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

}