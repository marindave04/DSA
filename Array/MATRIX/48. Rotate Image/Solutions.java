/*
| Approach                                                                                                                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Create temporary matrix, place each original row vertically into reversed columns to form 90° clockwise rotation, then copy temp back to original matrix | **O(n²)**       | **O(n²)**        |

*/
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] temp=new int[n][n];
        int col=n-1;
        for(int[] row:matrix){
            int[] nums=row;
            int idx=0;
            for(int r=0;r<n;r++){
                temp[r][col]=nums[idx++];
            }
            col--;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=temp[i][j];
            }
        }
    }
}
/*
| Approach                                                                                                              | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| First transpose matrix by swapping across diagonal, then reverse every row to achieve 90° clockwise in-place rotation | **O(n²)**       | **O(1)**         |

*/
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(j<=i) continue;
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int[] row:matrix){
            rev(row,matrix);
        }
    }
    static void rev(int[] row,int[][] matrx){
        int i=0;
        int j=row.length-1;
        while(i<j){
            int temp=row[i];
            row[i]=row[j];
            row[j]=temp;
            i++;
            j--;
        }
    }
}
