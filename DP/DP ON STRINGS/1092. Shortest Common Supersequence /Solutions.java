//BOTTOM - UP TABULATION APPROACH
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int[][] t=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) {
                    t[i][j]=i+j;
                
               }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=1+Math.min(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int p=m;
        int q=n;
        StringBuilder sb=new StringBuilder();
        while(p>0 && q>0){
            if(str1.charAt(p-1)==str2.charAt(q-1)){
                 sb.append(str1.charAt(p-1));
                 p--;
                 q--;
            }else{
                if(t[p-1][q]<=t[p][q-1]){
                     sb.append(str1.charAt(p-1));
                     p--;
                }else{
                    sb.append(str2.charAt(q-1));
                    q--;
                }
            }
        }
        while(p>0){
            sb.append(str1.charAt(p-1));
            p--;
        }
        while(q>0){
            sb.append(str2.charAt(q-1));
            q--;
        }
        sb=sb.reverse();
        return sb.toString();
    }
}
