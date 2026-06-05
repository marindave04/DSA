/*
Problem Link:https://www.desiqna.in/13822/google-dp-interview-question-jan-2023
*/
/*
| Approach                                                                                                                                               | Time     | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| Use DP where `dp[i][0]` and `dp[i][1]` store the number of ways to reach index `i` with an even or odd parity sum, considering jumps of length 1 or 2. | **O(N)** | **O(N)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int[] nums=new int[n+1];
   for(int i=1;i<n+1;i++){
       nums[i]=sc.nextInt();
   }
   //even->0
   //odd->1
   int[][] dp=new int[n+1][2];
   if(nums[1]%2==0){
       dp[1][0]=1;
       dp[1][1]=0;
   }else{
       dp[1][0]=0;
       dp[1][1]=1;
   }
   if(n==1){
        System.out.println(dp[n][0]+"-"+dp[n][1]);
        return;
   }
   if(nums[2]%2==0){
       dp[2][0]= dp[2][0]+dp[1][0];
       dp[2][1]=dp[2][1]+dp[1][1];
   }else{
       dp[2][0]= dp[2][0]+dp[1][1];
       dp[2][1]=dp[2][1]+dp[1][0];
   }
   if(n==2){
        System.out.println(dp[n][0]+"-"+dp[n][1]);
        return;
   }
   for(int i=3;i<n+1;i++){
       if(nums[i]%2==0){
       dp[i][0]= dp[i][0]+dp[i-1][0];
       dp[i][0]= dp[i][0]+dp[i-2][0];
       dp[i][1]=dp[i][1]+dp[i-1][1];
       dp[i][1]=dp[i][1]+dp[i-2][1];
      }else{
       dp[i][0]= dp[i][0]+dp[i-1][1];
       dp[i][0]= dp[i][0]+dp[i-2][1];
        dp[i][1]=dp[i][1]+dp[i-1][0];
       dp[i][1]=dp[i][1]+dp[i-2][0];
      }
   }
   System.out.println(dp[n][0]+"-"+dp[n][1]);
  }
}
