/*
| Approach                                                     | Time Complexity | Space Complexity |
| ------------------------------------------------------------ | --------------- | ---------------- |
| **Two Pointers (Greedy Traversal on Non-increasing Arrays)** | **O(n + m)**    | **O(1)**         |

*/
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int limit=nums2[m-1];
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                 if(nums1[i]<=limit){
                    int x=i;
                    for(int p=j;p<m;p++){
                        max=Math.max(max,p-x);
                    }
                    i++;
                    j++;
                 }else{
                     max=Math.max(max,j-i);
                    j++;
                 }
            }else if(nums1[i]>nums2[j] && i==j){
                i++;
                j++;
            }else{
                while(i<n && j<m && nums1[i]>nums2[j] && i<j ){
                    i++;
                }
            }
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }
}
