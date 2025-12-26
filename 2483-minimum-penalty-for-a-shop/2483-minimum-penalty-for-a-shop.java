class Solution {
    public int bestClosingTime(String customers) {
     int n=customers.length();
     int ans=0;
     int penalty=0;
     for(int i=0;i<n;i++){
        if(customers.charAt(i)=='Y') penalty++;
     }  
     if(penalty==1 && customers.charAt(0)=='N') return 0;
     int min=Integer.MAX_VALUE;
     int curr=penalty;
     for(int j=1;j<=n;j++){
        if(customers.charAt(j-1)=='Y'){
            curr=curr-1;
            if(curr<penalty){
                ans=j;
                penalty=curr;
            }
        }else{
            
            curr=curr+1;
            
        }
     }
     return ans;
    }
}