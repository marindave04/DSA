class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int col=strs[0].length();
        int lis=1;
        int[] t=new int[col];
        Arrays.fill(t,1);
        for(int i=0;i<col;i++){
            for(int j=0;j<i;j++){
                boolean temp=true;
                for(int k=0;k<n;k++){
                    if(strs[k].charAt(j)>strs[k].charAt(i)){
                        temp=false;
                        break;
                    }
                }
                if(temp){
                    t[i]=Math.max(t[i],t[j]+1);
                    lis=Math.max(lis,t[i]);
                }
            }
        }
        return col-lis;
    }
}