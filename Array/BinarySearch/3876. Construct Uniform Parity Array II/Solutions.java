/*
| Approach                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Sorting + Binary Search based parity transformation (try all even / all odd)** | **O(n log n)**  | **O(n)**         |

*/
class Solution {
    public boolean uniformArray(int[] nums1) {
          int n=nums1.length;
        Arrays.sort(nums1);
        int[] nums2=new int[n];
        //first we will try to make all even
        if(nums1[0]%2==0){
             for(int i=0;i<n;i++){
            
            if(nums1[i]%2==0){
                nums2[i]=nums1[i];
            }else {
               int low=0;
               int high=i-1;
               
               while(low<=high){
                   int mid=low+(high-low)/2;
                   if(nums1[mid]<=nums1[i]-1){
                       if((nums1[i]-nums1[mid])%2==0){
                           nums2[i]=nums1[mid];
                           break;
                       }else{
                           nums2[i]=nums1[i];
                       }
                       low=mid+1;
                   }else{
                       high=mid-1;
                   }
               }
            }
        }
        }
        //check if all even
        boolean even=true;
        for(int p=0;p<n;p++){
            if(nums2[p]%2!=0) {
                even=false;
                break;
            }
        }
        if(even==true) return true;
        //now we will try to make all odd
          for(int i=0;i<n;i++){
            if(nums1[i]%2!=0){
                nums2[i]=nums1[i];
            }else {
                   int low=0;
               int high=i-1;
               
               while(low<=high){
                   int mid=low+(high-low)/2;
                   if(nums1[mid]<=nums1[i]-1){
                       if((nums1[i]-nums1[mid])%2!=0){
                           nums2[i]=nums1[mid];
                           break;
                       }else{
                           nums2[i]=nums1[i];
                       }
                       low=mid+1;
                   }else{
                       high=mid-1;
                   }
               }
            }
        }
        //check if all odd
        boolean odd=true;
        for(int q=0;q<n;q++){
            if(nums2[q]%2==0){
                odd=false;
                break;
            }
        }
        if(odd==true) return true;
        return false;
    }
}
