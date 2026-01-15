class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int seq1=1;
        int maxSeq1=1;
        for(int i=0;i<hBars.length-1;i++){
            if(hBars[i+1]==hBars[i]+1){
                seq1++;
                maxSeq1=Math.max(maxSeq1,seq1);
            }else{
                seq1=1;
            }
        }

        int seq2=1;
        int maxSeq2=1;
        for(int i=0;i<vBars.length-1;i++){
            if(vBars[i+1]==vBars[i]+1){
                seq2++;
                maxSeq2=Math.max(maxSeq2,seq2);
            }else{
                seq2=1;
            }
        }
        long width=(long) maxSeq1+1;
        long height=(long) maxSeq2+1;
        long length=(long)Math.min(width,height);
        return (int) (length*length);
    }
}