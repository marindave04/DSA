/*
| Type               | Complexity         | Reason                                        |
| ------------------ | ------------------ | --------------------------------------------- |
| Time Complexity    | `O(log n)`         | mask build karne me bits process ho rahi hain |
| Space Complexity   | `O(1)`             | sirf constant variables                       |
| Dominant Operation | mask building loop |                                               |

*/

class Solution {
    public int findComplement(int n) {
        if(n==0) return 1;
       int mask=1;
       while(mask<n){
        mask=mask<<1|1;
       }
       return mask^n;
    }
}
