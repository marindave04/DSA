class Solution {
    public int longestSubstring(String s, int k) {
       
       int n=s.length();
       
       return solve(s,0,n,k);
    }
    static int solve(String s,int start,int end,int k){
       if(end<k) return 0;

       int[] freq=new int[26];
       for(int i=start;i<end;i++){
        freq[s.charAt(i)-'a']++;
       }
       for(int mid=start;mid<end;mid++){
       if (freq[s.charAt(mid)-'a']>=k) continue;
       int midNext=mid+1;
       while(midNext<end && freq[s.charAt(midNext)-'a']<k) midNext++;
       int left=solve(s,start,mid,k);
       int right=solve(s,midNext,end,k);
       return Math.max(left,right);
       }
       return (end-start);
    }
}