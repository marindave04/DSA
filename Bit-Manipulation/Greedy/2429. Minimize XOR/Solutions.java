/*
| Approach                                                                                                                     | Time      | Space    |
| ---------------------------------------------------------------------------------------------------------------------------- | --------- | -------- |
| Count required set bits from `num2`, then greedily set bits in `x` matching high bits of `num1` first to minimize XOR value. | **O(32)** | **O(1)** |

*/
class Solution {
    public int minimizeXor(int num1, int num2) {
        int k=solve(num2);
        int setBit=0;
        int currentBit=31;
        int x=0;
        while(setBit<k){
            if(checkForSetBit(num1,currentBit)|| (k-setBit>currentBit)){
                x=addSetBit(x,currentBit);
                setBit++;
            }
            currentBit--;
        }
        return x;
    }
    static int solve(int n){
        int count=0;
        while(n>0){
            int rem=n%2;
            if(rem==1) count++;
            n=n/2;
        }
        return count;
    }
    static boolean checkForSetBit(int num,int bit){
        int g=(num & (1<<bit));
        if(g!=0) return true;
        return false;
    }
    static int addSetBit(int x,int bit){
        return x|(1<<bit);
    }
}
