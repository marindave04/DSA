class Solution {
    public int maxOnes(int nums[], int k) {
        // code here
       int n=nums.length;
       int i=0;
       int j=0;
       int count=0;
       int max=0;
       while(j<n){
          
           if(count<=k){
                if(nums[j]==0) count++;
               
           }
           while(count>k){
               max=Math.max(max,j-i);
               if(nums[i]==0) count--;
               i++;
           }
            if(count<=k) j++;
       }
       max=Math.max(max,j-i);
       return max;
    }
}
