/*
| Approach                                                               | Time Complexity    | Space Complexity |
| ---------------------------------------------------------------------- | ------------------ | ---------------- |
| **Row-wise Histogram + Sorting each row (to maximize submatrix area)** | **O(m · n log n)** | **O(n)**         |

*/

class Solution {
    public int largestSubmatrix(int[][] matrix) {
         int m=matrix.length;
        
         int area=0;
         for(int i=0;i<m;i++){
            int n=matrix[i].length;
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(matrix[i][j]>0){
                    if(i>0){
                        if(matrix[i-1][j]>=1) matrix[i][j]=matrix[i-1][j]+1;
                    }
                }
                curr[j]=matrix[i][j];
            }
            Arrays.sort(curr);
            reverse(curr);
            for(int k=0;k<curr.length;k++){
                int x=curr[k]*(k+1);
                if(curr[k]>0){
                   area= Math.max(area,x);
                }
            }
         }
         return area;
    }
    static void reverse(int[] nums){
        for(int i=0;i<nums.length/2;i++){
            int temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
    }
}
