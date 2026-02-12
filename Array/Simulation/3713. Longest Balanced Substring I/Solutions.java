class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int x=freq[ch-'a'];
                boolean flag=true;
                for(int k=0;k<26 ;k++){
                    if(freq[k]==0) continue;
                    if(freq[k]!=x){
                        flag=false;
                        break;
                    } 
                   
                }
                if(flag){
                    max=Math.max(max,j-i+1);
                }
              
            }
        }
        return max;
    }
}
