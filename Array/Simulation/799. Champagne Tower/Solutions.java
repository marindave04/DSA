class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
          // problem structure is same like pascal's triangle but hum yha per hum excess value ko simulate krke add kr rhe hai
          double[][] t= new double[101][101];
          t[0][0]=poured;
          for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                if(t[i][j]>1.0){
                 double x=(t[i][j]-1)/2.0;
                 t[i][j]=1.0;
                 t[i+1][j]+=x;
                 t[i+1][j+1]+=x;
                }
            }
          }
          return t[query_row][query_glass];
    }
}
