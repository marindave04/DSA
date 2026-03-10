/*
| Complexity Type           | Value                      | Reason                               |
| ------------------------- | -------------------------- | ------------------------------------ |
| **Time Complexity**       | **O(zero × one)**          | Two nested loops over zeros and ones |
| **Space Complexity**      | **O(zero × one × 2)**      | 3D DP table                          |
| **Auxiliary Space**       | **O(zero × one)**          | Only DP storage                      |
| **Transitions per state** | **O(1)**                   | Constant DP calculations             |
| **Total States**          | **(zero+1) × (one+1) × 2** | Each combination stored              |

*/

class Solution {
     static int m=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
     int[][][] t=new int[zero+1][one+1][2];
     //base case
     for(int i=0;i<=Math.min(zero,limit);i++){
        t[i][0][0]=1;
     }
     for(int j=0;j<=Math.min(one,limit);j++){
        t[0][j][1]=1;
     }
     for(int i=0;i<=zero;i++){
        for(int j=0;j<=one;j++){
            if(i==0 || j==0) continue;
            t[i][j][1]=(t[i][j-1][1]+t[i][j-1][0])%m;
            if(j-1>=limit){
                t[i][j][1]=(t[i][j][1]-t[i][j-1-limit][0]+m)%m;
            }
              t[i][j][0]=(t[i-1][j][0]+t[i-1][j][1])%m;
            if(i-1>=limit){
                t[i][j][0]=(t[i][j][0]-t[i-1-limit][j][1]+m)%m;
            }
        }
     }
     return (t[zero][one][0]+t[zero][one][1])%m;
    }
}
