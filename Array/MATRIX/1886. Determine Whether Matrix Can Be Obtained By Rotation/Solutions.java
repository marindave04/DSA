/*
| Approach                                                          | Time Complexity | Space Complexity |
| ----------------------------------------------------------------- | --------------- | ---------------- |
| **Matrix Rotation (Transpose + Reverse) + Check all 4 rotations** | **O(n²)**       | **O(1)**         |

*/
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int rot=0;rot<4;rot++){
            rotate(mat);
            boolean flag=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                  if(mat[i][j]!=target[i][j]){
                    flag=false;
                    break;
                  }
                }
                if(flag==false) break;
            }
            if(flag) return true;
        }
        return false;
    }
    static void rotate(int[][] mat){
        int n=mat.length;
        for(int i=0;i<n;i++ ){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        reverse(mat);
    }
    static void reverse(int[][] grid){
        int n=grid.length;
        for(int i=0;i<n;i++){
            int s=0;
            int e=n-1;
            while(s<=e){
                int temp=grid[i][s];
                grid[i][s]=grid[i][e];
                grid[i][e]=temp;
                s++;
                e--;
            }
        }
    }
}
