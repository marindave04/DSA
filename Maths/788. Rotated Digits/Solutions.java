/*
| Approach                                                                                                                                                                          | Time Complexity  | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------- | ---------------- |
| Iterate from `1` to `n`, check each number digit by digit: reject invalid digits (`3,4,7`), ensure at least one changing valid digit (`2,5,6,9`), then count good rotated numbers | **O(n · log n)** | **O(1)**         |

*/
class Solution {
    public int rotatedDigits(int n) {
       int count=0;
       for(int i=1;i<=n;i++){
        if(check(i)) count++;
       }
       return count;
    }
    static boolean check(int n){
        boolean flag=false;
        while(n>0){
            int rem=n%10;
            if(rem==4 || rem==7 || rem==3) return false;
            if(rem==2 || rem==5 || rem==6 || rem==9){
                flag=true;
            }
            n=n/10;
        }
        return flag;
    }
}
