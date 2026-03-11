/*
| Type               | Complexity                  | Reason                                   |
| ------------------ | --------------------------- | ---------------------------------------- |
| Time Complexity    | `O(log n)`                  | binary bits process ho rahe hain         |
| Space Complexity   | `O(log n)`                  | StringBuilder me bits store ho rahi hain |
| Dominant Operation | binary processing + parsing |                                          |

*/
class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb=new StringBuilder();
        if(n==0) return 1;
        while(n>0){
            int rem=1-n%2;
            char ch=(char)(rem + '0');
            sb.append(ch);
            n=n/2;
        }
        sb.reverse();
        int decimal=Integer.parseInt(sb.toString(),2);
        return decimal;
    }
}

/*
| Type             | Complexity                              |
| ---------------- | --------------------------------------- |
| Time Complexity  | `O(log n)`                              |
| Space Complexity | `O(1)`                                  |
| Reason           | binary conversion takes `log₂(n)` steps |

*/

class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
       int[] a=new int[32];
       int[] b=new int[32];
       int idx=31;
       while(n>0){
        a[idx]=n%2;
        b[idx--]=1;
        n=n/2;
        
       } 
       int ans=0;
       for(int i=31;i>=0;i--){
          int bit=b[i]-a[i];
          ans=ans+bit*(int)Math.pow(2,31-i);
       }
       return ans;
    }
}
