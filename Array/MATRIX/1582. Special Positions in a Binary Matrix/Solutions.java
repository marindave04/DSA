//Approach 1: Brute Force
//Time complexity: O(m⋅n⋅(m+n))
//Space complexity: O(1)
class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(mat[i][j]==1){
                 if(check(mat,i,j)) count++;
               }
            }
        }
        return count;
    }
    static boolean check(int[][] mat,int x,int y){
        boolean flag1=true;
        boolean flag2=true;
        int m=mat.length;
        int n=mat[0].length;
        //check column
        for(int c=0;c<n;c++){
            if(c==y) continue;
            if(mat[x][c]!=0){
                flag1=false;
                break;
            }
        }
        //check row
        for(int r=0;r<m;r++){
            if(r==x) continue;
            if(mat[r][y]!=0){
                flag2=false;
                break;
            }
        }
        if(flag1==true && flag2==true) return true;
        return false;
    }
}
  //Approach 2: Precompute the Number of Ones in each Row and Column
  //Time complexity: O(m⋅n)
  //Space complexity: O(m+n)

class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        int m=mat.length;
        int n=mat[0].length;
        int[] rowCount=new int[m];
        int[] colCount=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1) rowCount[i]++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[j][i]==1) colCount[i]++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(mat[i][j]==1){
                 if(rowCount[i]<=1 && colCount[j]<=1) count++;
               }
            }
        }
        return count;
    }
    
}
    
