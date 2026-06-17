/*
| Approach                                                                                                                                                                            | Time Complexity | Space Complexity |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Compute the final length of the transformed string without explicitly constructing it, then traverse the operations in reverse to map the index `k` back to the original character. | **O(N)**        | **O(1)**         |

*/
/*
| Step        | Approach                                                                                                           | Time     | Space    |
| ----------- | ------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| 1           | Scan the string once and compute the final length after applying all operations (`#`, `*`, `%`).                   | **O(N)** | **O(1)** |
| 2           | Traverse the operations in reverse and undo each operation to trace the position `k` back to its source character. | **O(N)** | **O(1)** |
| **Overall** | No transformed string is ever built; only length and index mappings are maintained.                                | **O(N)** | **O(1)** |

*/
class Solution {
    public char processStr(String s, long k) {
        long L=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                L=(long)2*L;
            }else if(ch=='*'){
                if(L>0) L=(long)L-1;
            }else if(ch=='%'){
                continue;
            }else{
                  L=(long)L+1;
            }
        }
        if(k>=L) return '.';
        for(int i=n-1;i>=0;i--){
             char ch=s.charAt(i);
            if(ch=='#'){
               L=L/2;
               if(k>=L){
                k=k-L;
               }
               if(k==L) return ch;
            }else if(ch=='*'){
                L=(long)L+1;
                if(k==L) return ch;
            }else if(ch=='%'){
                k=L-k-1;
                if(k==L) return ch;
            }else{
                  L=(long)L-1;
                   if(k==L) return ch;
            }
        }
        return '.';
    }
}
