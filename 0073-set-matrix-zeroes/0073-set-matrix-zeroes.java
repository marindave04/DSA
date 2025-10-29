class Solution {
    public void setZeroes(int[][] matrix) {
        int m =matrix.length;
        int n =matrix[0].length;
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    map1.put(i,matrix[i][j]);
                    map2.put(j,matrix[i][j]);
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()){
            if(entry.getValue()==0){
                int row=entry.getKey();
                for(int p=0;p<n;p++){
                    matrix[row][p]=0;
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry: map2.entrySet()){
            if(entry.getValue()==0){
                int col=entry.getKey();
                for(int q=0;q<m;q++){
                    matrix[q][col]=0;
                }
            }
        }
    }
}