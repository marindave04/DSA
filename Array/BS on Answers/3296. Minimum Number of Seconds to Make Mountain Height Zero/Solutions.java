/*
| Approach                                                            | Time Complexity                                 | Space Complexity |
| ------------------------------------------------------------------- | ----------------------------------------------- | ---------------- |
| **Binary Search on Time + Binary Search to find k (k(k+1) ≤ 2t/w)** | **O(n · log(1e18) · log(2t/w)) ≈ O(n · log²T)** | **O(1)**         |

*/
class Solution {
    public long minNumberOfSeconds(int height, int[] nums) {
       int n=nums.length;
       int equal=height/n;
       int min=Arrays.stream(nums).min().getAsInt();
       int max=Arrays.stream(nums).max().getAsInt();
       long low=1;
       long high=(long)1e18;
       long ans=0;
       while(low<=high){
          long mid=(long)low+(long)(high-low)/2;
          if(check(mid,height,nums)){
            ans=mid;
            high=(long)mid-1;
          }else{
            low=(long)mid+1;
          }
       }
       return ans;
    }
    static boolean check(long t,long h,int[]nums){
        for(int i=0;i<nums.length;i++){
            long low=1;
            long high=(long)(t*2)/(long)nums[i];
            long x=high;
            long count=0;
            while(low<=high){
                 long mid=(long)low+(long)(high-low)/2;
                if(mid <= x/(mid+1)){
    count = mid;
    low = mid+1;
}else{
    high = mid-1;
}
            }
            h=(long)h-count;
        }
        if(h<=0) return true;
        return false;
    }
}
/*
| Approach                                                                    | Time Complexity                     | Space Complexity |
| --------------------------------------------------------------------------- | ----------------------------------- | ---------------- |
| **Binary Search on Time + Direct Formula (Quadratic Formula to compute k)** | **O(n · log(1e18)) ≈ O(n · log T)** | **O(1)**         |

*/
class Solution {
    public long minNumberOfSeconds(int height, int[] nums) {
       int n=nums.length;
       int equal=height/n;
       int min=Arrays.stream(nums).min().getAsInt();
       int max=Arrays.stream(nums).max().getAsInt();
       long low=1;
       long high=(long)1e18;
       long ans=0;
       while(low<=high){
          long mid=(long)low+(long)(high-low)/2;
          if(check(mid,height,nums)){
            ans=mid;
            high=(long)mid-1;
          }else{
            low=(long)mid+1;
          }
       }
       return ans;
    }
    static boolean check(long t,long h,int[]nums){
        for(int i=0;i<nums.length;i++){
           
            long c=(long)(t*2)/(long)nums[i];
            long x=(long)((long)-1+(long)Math.sqrt(1+4*c))/2;
            h=(long)h-x;
        }
        if(h<=0) return true;
        return false;
    }
}
