/*
| Approach                                                                                                                                     | Time          | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------------- | ------------- | -------- |
| Try every pair of target remainders for even and odd indices, compute minimum operations for both assignments, and take the minimum overall. | **O(K² · N)** | **O(1)** |

*/
class Solution {
    public int minOperations(int[] nums, int k) {
      int n=nums.length;
      int min=Integer.MAX_VALUE;
      for(int i=0;i<k-1;i++){
        for(int j=i+1;j<k;j++){
            int x=i;
            int y=j;
            int count1=solve(nums,x,y,k);
            x=j;
            y=i;
            int count2=solve(nums,x,y,k);
             min=Math.min(min,Math.min(count1,count2));
        }
      }
      return min;
    }
    int solve(int[] nums,int x,int y,int k){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                    int rem=nums[i]%k;
                    int op1=Math.min((rem-x+k)%k,(x-rem+k)%k);
                    count+=op1;
                
            }else{
               int rem=nums[i]%k;
                    int op2=Math.min((rem-y+k)%k,(y-rem+k)%k);
                    count+=op2;
                }
            }
        
        return count;
    }
}
