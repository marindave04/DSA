class Solution {
    public int[] minOperations(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=solve1(nums[i]);
        }
       return ans;
    }
    int solve1(int n){
        int low=0;
        for(int i=n;i>=0;i--){
            if(solve2(i)){
                low=n-i;
                break;
            }
        }
        int high=0;
        int num=n;
        while(true){
            if(solve2(num)){
                high=num-n;
                break;
            }
            num++;
        }
        return (int)Math.min(low,high);
    }
    boolean solve2(int x){
        String s=Integer.toBinaryString(x);
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}