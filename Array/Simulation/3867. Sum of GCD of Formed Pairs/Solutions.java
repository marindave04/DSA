class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] pmax=new int[n];
        pmax[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pmax[i]=Math.max(pmax[i-1],nums[i]);
        }
        int[] pGcd=new int[n];
        for(int i=0;i<n;i++){
            pGcd[i]=gcd(nums[i],pmax[i]);
        }
        Arrays.sort(pGcd);
        long sum=0;
        int i=0;
        int j=n-1;
        while(i<j){
            int temp=gcd(pGcd[i],pGcd[j]);
            sum=(long) sum+temp;
            i++;
            j--;
        }
        return sum;
    }
    static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
