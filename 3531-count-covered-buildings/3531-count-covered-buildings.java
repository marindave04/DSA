class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        
         int[]maxCol=new int[n+1];
         int[]minCol=new int[n+1];
         int[]maxRow=new int[n+1];
         int[]minRow=new int[n+1];
         Arrays.fill(minCol,n+1);
         Arrays.fill(minRow,n+1);
         for(int[] num:buildings){
            int x=num[0];
            int y=num[1];
            maxRow[y]=Math.max(maxRow[y],x);
            minRow[y]=Math.min(minRow[y],x);
            maxCol[x]=Math.max(maxCol[x],y);
            minCol[x]=Math.min(minCol[x],y);
         }
        
        int count=0;
        for(int i=0;i<buildings.length;i++){
            int x=buildings[i][0];
            int y=buildings[i][1];
            if(x < maxRow[y] && x>minRow[y] && y<maxCol[x] && y>minCol[x]) count++;
        }
        return count;
    }
}