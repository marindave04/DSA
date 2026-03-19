//BRUTR FORCE
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int count=0;
        for(int i=0;i<m;i++){
            int n=grid[i].length;
            for(int j=0;j<n;j++){
                    int cx=0;
                    int cy=0;
                    //(tracking all submatrices from (0,0) to (i,j))
                for(int x=0;x<=i;x++){
                    
                    for(int y=0;y<=j;y++){
                        if(grid[x][y]=='X'){
                            cx++;
                        }else if(grid[x][y]=='Y'){
                            cy++;
                        }
                    }
                   
                }
                 if(cx>0 && (cx==cy)) count++;
            }
        }
        return count;
    }
}
//OPTIMAL
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] px=new int[m][n];
        int[][] py=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                px[i][j]=(grid[i][j]=='X'?1:0);
                py[i][j]=(grid[i][j]=='Y'?1:0);
                //left 
                if(j>0){
                    px[i][j]+=px[i][j-1];
                    py[i][j]+=py[i][j-1];
                }
                //top
                if(i>0){
                   px[i][j]+=px[i-1][j];
                    py[i][j]+=py[i-1][j]; 
                }
                //remove diagonal elemnet
                if(i>0 && j>0){
                    px[i][j]-=px[i-1][j-1];
                    py[i][j]-=py[i-1][j-1];
                }
                if(px[i][j]==py[i][j] && (px[i][j]>0)) count++;
            }
        }
        return count;
    }
}
