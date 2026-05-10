/*
| Approach                                                                                                                         | Time     | Space    |
| -------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Count `0`s and `1`s, handle edge cases separately, then compute minimum flips based on string pattern and character frequencies. | **O(n)** | **O(1)** |

*/
class Solution {
    public int minFlips(String s) {
        int c0=0;
        int c1=0;
        int n=s.length();
        if(n<3) return 0;
        if(n==3){
            if(!s.equals("110") && !s.equals("011")){
                return 0;
            }
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                c0++;
            }else{
                c1++;
            }
        }
        if(c1==0 || c0==0) return 0;
        if(s.charAt(0)=='1' && s.charAt(n-1)=='1'){
            if(c0==n-2){
                return 0;
            }else{
                c1=c1-2;
                return Math.min(c0,c1);
            }
        }
        if(c0<c1){
            return c0;
        }
        return c1-1;
    }
}
