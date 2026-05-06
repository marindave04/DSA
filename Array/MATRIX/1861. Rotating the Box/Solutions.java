/*
| Approach                                                                                                                                                              | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| For each row simulate gravity by sliding stones `#` rightward within `*` blocked segments using two pointers, then rotate resulting box 90° clockwise into new matrix | **O(m × n)**    | **O(m × n)**     |

*/
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        for(int row=0;row<m;row++){
            int i=0;
            int j=0;
            while(j<n){
               if(box[row][i]=='.' && box[row][j]=='.'){
                i++;
                j++;
               }else  if(box[row][i]=='#' && box[row][j]=='#'){
                    j++;
                }else if(box[row][i]=='#' && box[row][j]=='.'){
                    char temp=box[row][i];
                    box[row][i]=box[row][j];
                    box[row][j]=temp;
                    i++;
                    j++;
                }else if(box[row][j]=='*'){
                    j++;
                    i=j;
                }
            }
        }
        char[][] ans=new char[n][m];
        int col=m-1;
        for(char[] row:box){
            char[] temp=row;
            int idx=0;
            int r=0;
            while(r<n){
                ans[r][col]=temp[idx++];
                r++;
            }
            col--;
        }
        return ans;
    }
}
