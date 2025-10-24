class Solution {
    public int nextBeautifulNumber(int n) {
       int max=6666666;
       
       for(int i=n+1;i<=max;i++){
        
        int num=i;
        int[] freq=new int[10];
        while(num>0){
            int digit=num%10;
            freq[digit]++;
            num=num/10;
        }
        if(freq[0]>0) continue;
        boolean flag=true;
        for(int j=1;j<10;j++){
        
            if(freq[j]!=0 && freq[j]!=j){
                flag=false;
            }
        }
        if(flag) return i;
       } 
       return 0;
    }
}