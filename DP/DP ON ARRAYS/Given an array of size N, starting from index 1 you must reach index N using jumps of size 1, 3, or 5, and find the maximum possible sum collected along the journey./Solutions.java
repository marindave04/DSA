/*
Problem:->You are given an array of size “N” ; you have to start your journey at index “1” and you need to end your journey at index “N”.You can make jumps of size -> 1 or 3 or http://5.In the array positive as well as negative numbers can be available.Please find the maximum sum of journey
*/
/*
| Approach                                                                                                                          | Time     | Space    |
| --------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use dynamic programming where each state stores the maximum obtainable sum at index `i` considering all allowed jump transitions. | **O(N)** | **O(N)** |

*/
import java.util.*;
public class Main{
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
            int[] nums=new int[n+1];
            for(int i=1;i<n+1;i++){
                nums[i]=sc.nextInt();
            }
           int[] dp=new int[n+1];
           Arrays.fill(dp,Integer.MIN_VALUE);
           dp[1]=nums[1];
           if(n==1){
                System.out.println(dp[1]);
                return;
           }
           dp[2]=nums[1]+nums[2];
            if(n==2){
                System.out.println(dp[2]);
                return;
           }
           dp[3]=nums[1]+nums[2]+nums[3];
            if(n==3){
                System.out.println(dp[3]);
                return;
           }
           for(int i=4;i<n+1;i++){
                int temp1=dp[i-1]+nums[i];
                int temp2=dp[i-3]+nums[i];
                int temp3=i-5>=1 ? dp[i-5]+nums[i] : Integer.MIN_VALUE;
                dp[i]=Math.max(temp1,Math.max(temp2,temp3));
           }
          System.out.println(dp[n]);
     }
}
