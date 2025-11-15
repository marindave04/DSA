class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        Arrays.sort(potions);
        int[] pairs=new int [n];
        
        for(int i=0;i<n;i++){
            long ans=-1;
            long low=0;
            long high=m-1;
            while(low<=high){
                long mid = low+(high-low)/2;
                if(((long)potions[(int)mid]*spells[i])>=success){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            if(ans==-1){
                pairs[i]=0;
            }else{
                pairs[i]=(int)(m-ans);
            }
        }
        return pairs;
    }
}