/*
| Approach                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Brute Force (Try making all elements even or all odd using pair differences)** | **O(n²)**       | **O(n)**         |

*/
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int[] nums2=new int[n];
        //first we will try to make all even
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                nums2[i]=nums1[i];
            }else {
                for(int j=0;j<n;j++){
                    if(j==i) continue;
                    int diff=nums1[i]-nums2[j];
                    if(diff%2==0){
                        nums2[i]=diff;
                        break;
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
                for(int j=0;j<n;j++){
                    if(j==i) continue;
                    int diff=nums1[i]-nums2[j];
                    if(diff%2!=0){
                        nums2[i]=diff;
                        break;
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
/*
| Approach                                       | Time Complexity | Space Complexity |
| ---------------------------------------------- | --------------- | ---------------- |
| **Trivial / Constant Return (No computation)** | **O(1)**        | **O(1)**         |

*/
class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
