class Solution {
    private ArrayList<String> rowStates=new ArrayList<>();
    
    static int mod=1000000007;
    public int numOfWays(int n) {
   //since columns are less toh hum row state bnayenge taake hr row state me columns ki length yaani string ki length kam hogi
     generateRowStates("",'#',0);
     int[][] t=new int[rowStates.size()][n];
     int result=0;
     for(int[]row:t){
        Arrays.fill(row,-1);
     }
     for(int i=0;i<rowStates.size();i++){
         result=(result+solve(i,n-1,t))%mod;
     }
     return result;
    }
    private int solve(int prevIdx,int remRows,int[][] t){
        if(remRows==0) return 1;
        if(t[prevIdx][remRows]!=-1) return t[prevIdx][remRows];
        String prevState=rowStates.get(prevIdx);
        int ways=0;
        for(int i=0;i<rowStates.size();i++){
            if(i==prevIdx) continue;
            String currState=rowStates.get(i);
            boolean flag=true;
            for(int j=0;j<3;j++){
               if(currState.charAt(j)==prevState.charAt(j)){
                flag=false;
                break;
               }
            }
           if(flag){
            ways=(ways+solve(i,remRows-1,t))%mod;
           }
        }
        return t[prevIdx][remRows]=ways;
    }
    private void generateRowStates(String curr,Character prev,int l){
        if(l==3){
            rowStates.add(curr);
            return;
        }
            for(char ch:"RYG".toCharArray()){
                if(ch==prev) continue;
                generateRowStates(curr+ch,ch,l+1);
            }
        }
    
}