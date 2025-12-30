class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row<3 || col<3) return 0;
        int count=0;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                if(isMagic(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    static boolean isMagic(int[][] grid,int i,int j){
        //check, every element in the grid is unique and is between 1 and 9
        HashSet<Integer> set=new HashSet<>();
        for(int p=i;p<3+i;p++){
            for(int q=j;q<3+j;q++){
                int num=grid[p][q];
                if(num<1 || num>9 || set.contains(num)){
                    return false;
                }else{
                    set.add(num);
                }
            }
        }
        //finding rosum
        boolean tempRow=false;
        for(int p=i;p<3+i;p++){
            int rowSum=grid[p][j]+grid[p][j+1]+grid[p][j+2];
            if(rowSum==15){
                tempRow = true;
            }else{
                return false;
            }
        }
        //finding colsum
        boolean tempCol=false;
        for(int q=j;q<3+j;q++){
            int colSum=grid[i][q]+grid[i+1][q]+grid[i+2][q];
            if(colSum==15){
                tempCol=true;
            }else{
                return false;
            }
        }
        //finding diagonal sum
        int d1=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int d2=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        if(d1!=15 || d2!=15) return false;
        if(d1==15 && d2==15 ){
            if(tempCol && tempRow){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}