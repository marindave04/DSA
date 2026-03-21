/*
| Approach                                                      | Time Complexity | Space Complexity |
| ------------------------------------------------------------- | --------------- | ---------------- |
| **Column-wise reversal of k×k submatrix (in-place swapping)** | **O(k²)**       | **O(1)**         |

*/
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        //EID SPECIAL
         for(int c=y;c<k+y;c++){
            reverse(x,c,grid,k);
         }
         return grid;
    }
    static void reverse(int i,int j,int[][] grid,int k){
        int x=i;
        int y=k+i-1;
        while(x<y){
            int temp=grid[x][j];
            grid[x][j]=grid[y][j];
            grid[y][j]=temp;
            x++;
            y--;
        }
    }
}
