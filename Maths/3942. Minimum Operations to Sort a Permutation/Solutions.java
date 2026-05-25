/*
| Approach                                                                                                                                      | Time     | Space    |
| --------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Find position of `0`, verify whether array forms forward or backward cyclic order, then compute minimum rotations/reversal operations needed. | **O(N)** | **O(1)** |

*/
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                idx=i;
                break;
            }
        }
        boolean forward=true;
        boolean backward=true;
        //forward cycling checking
        for(int i=1;i<n;i++){
            if(nums[(idx+i)%n]!=i){
                forward=false;
                break;
            }
        }
         //backward cycling checking
        for(int i=1;i<n;i++){
            if(nums[(idx-i+n)%n]!=i){
                backward=false;
                break;
            }
        }
        if((!forward) && (!backward)) return -1;
        int ans=Integer.MAX_VALUE;
        if(forward){
            if(idx==0){
                return 0;
            }else{
                ans=Math.min(ans,idx);
                ans=Math.min(ans,(n-idx)+2);
            }
        }else{
            ans=Math.min(ans,idx+2);
             ans=Math.min(ans,n-idx);
        }
        return ans;
    }
}
