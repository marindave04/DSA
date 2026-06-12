/*| Approach                                                                                                                                                               | Time     | Space    |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Precompute prefix counts of `1`s and suffix counts of `0`s. For every split position, compute flips needed to make the left part all `0`s and the right part all `1`s. | **O(N)** | **O(N)** |
*/
class Solution {
    public int minFlipsMonoIncr(String str) {
       int n=str.length();
       int[] p=new int[n];
       int[] s=new int[n];
       for(int i=0;i<n;i++){
        char ch=str.charAt(i);
        if(ch=='1'){
            p[i]=(i-1>=0 ? p[i-1] :0 )+1;
        }else{
            p[i]=(i-1>=0 ? p[i-1] :0 );
        }
       }
       for(int i=n-1;i>=0;i--){
         char ch=str.charAt(i);
         if(ch=='0'){
            s[i]=(i+1<n ? s[i+1] :0 )+1;
        }else{
            s[i]=(i+1<n ? s[i+1] :0 );
        }
       }
       int ans=Math.min(p[n-1],s[0]);
       for(int i=0;i<n-1;i++){
        ans=Math.min(ans,p[i]+s[i+1]);
       }
       return ans;
       }
    }
