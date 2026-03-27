/*
| Approach                                                                                 | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------------------------- | --------------- | ---------------- |
| **Row-wise Rotation using Reversal (even → right shift, odd → left shift) + Comparison** | **O(m · n)**    | **O(m · n)**     |

*/
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        k=k%n;
        int idx=0;
        int[][] copy=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                copy[i][j]=mat[i][j];
            }
        }
        for(int[] row:mat){
           if(idx%2==0){
            reverse(row,0,k-1);
            reverse(row,k,n-1);
            reverse(row,0,n-1);
           }else{
              reverse(row,0,n-1);
              reverse(row,0,k-1);
              reverse(row,k,n-1);
           }
           idx++;
        }
       boolean result=Arrays.deepEquals(mat,copy);
       return result;
    }
    static void reverse(int[] nums,int i,int j){
        int s=i;
        int e=j;
        while(s<=e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}
/*
| Approach                                                               | Time Complexity | Space Complexity |
| ---------------------------------------------------------------------- | --------------- | ---------------- |
| **Direct Index Mapping (Check cyclic shift without modifying matrix)** | **O(m · n)**    | **O(1)**         |

*/
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        k=k%n;
        if(k==0) return true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=mat[i][(j+k)%n]) return false;
            }
        }
        return true;
    }
}
