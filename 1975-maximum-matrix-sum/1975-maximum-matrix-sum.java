class Solution {
    public long maxMatrixSum(int[][] matrix) {
    int n=matrix.length;
    ArrayList<Integer> list=new ArrayList<>();
    long min=Long.MAX_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]<0) list.add(matrix[i][j]);
            min=(long)Math.min(min,(long)Math.abs(matrix[i][j]));
        }
    }
    
    long sum=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            
                sum=(long) sum+(long)Math.abs(matrix[i][j]);
            
        }
    }
    if(list.size()%2==0) return sum;
    return (long)(sum-(2*min));
    }
}