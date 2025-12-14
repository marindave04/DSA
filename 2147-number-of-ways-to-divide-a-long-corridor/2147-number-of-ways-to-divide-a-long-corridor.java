class Solution {
    public int numberOfWays(String corridor) {
        String s=corridor;
     int countS=0;
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='S')countS++;
     }
     if(countS==0) return 0;
     if(countS%2!=0) return 0;
     if(countS%2==0 && countS==s.length()) return 1;
     if(countS==2) return 1;
    int j=0;
    int temp1=0;
    int temp2=0;
    long count=1;
    int countP=0;
    int mod=1000000007;
    while(j<s.length()){
        if(s.charAt(j)=='S' && temp1<2){
            temp1++;
            j++;
        }else if(s.charAt(j)=='P' && temp1!=2){
            j++;
        }
        if(temp1==2){
            
        
            if(j<s.length() && s.charAt(j)=='P' && temp2==0){
                countP++;
                j++;
            }else if(j<s.length() && s.charAt(j)=='S'){
                temp2++;
                j++;
            }else{
                j++;
            }
            if(temp1==temp2){
                count=(count*(long)(countP+1))%mod;
                temp1=temp2;
                temp2=0;
                countP=0;
              
            }        
        }
    }
    return (int)count;
    }
}