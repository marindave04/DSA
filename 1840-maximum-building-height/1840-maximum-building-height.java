class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
       List<int[]> list=new ArrayList<>();
       list.add(new int[]{1,0});
       for(int[] row:restrictions){
        list.add(row);
       }
       list.add(new int[]{n,Integer.MAX_VALUE});
       restrictions=list.toArray(new int[list.size()][2]);
       for(int[] r:restrictions){
        r[0]=r[0]-1;
       }
       Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

       for(int i=0;i<=restrictions.length-2;i++){
        restrictions[i+1][1]=Math.min(restrictions[i+1][1],restrictions[i][1]+(restrictions[i+1][0]-restrictions[i][0]));
       }
       for(int i=restrictions.length-2;i>=0;i--){
        restrictions[i][1]=Math.min(restrictions[i][1],restrictions[i+1][1]+(restrictions[i+1][0]-restrictions[i][0]));
       }
       int ans=0;
       for(int i=0;i<restrictions.length-1;i++){
        int maxHeight=Math.max(restrictions[i][1],restrictions[i+1][1]);
        int d=restrictions[i+1][0]-restrictions[i][0];
        int heightDiff=(int)Math.abs(restrictions[i][1]-restrictions[i+1][1]);
        int peak=maxHeight+(d-heightDiff)/2;
        ans=Math.max(ans,peak);
       }
       return ans;
    }
}