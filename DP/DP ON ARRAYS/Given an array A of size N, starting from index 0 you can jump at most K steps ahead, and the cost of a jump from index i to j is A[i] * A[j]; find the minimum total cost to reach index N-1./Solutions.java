/*
Problem:->Given an array A of size N, starting from index 0 you can jump at most K steps ahead, and the cost of a jump from index i to j is A[i] * A[j]; find the minimum total cost to reach index N-1.
*/
/*
| Approach                                                                                                      | Time         | Space    |
| ------------------------------------------------------------------------------------------------------------- | ------------ | -------- |
| Use dynamic programming where `dp[i]` stores minimum cost to reach index `i` by checking all jumps up to `k`. | **O(N · K)** | **O(N)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int k=sc.nextInt();
       int[] nums=new int[n];
       for(int i=0;i<n;i++){
           nums[i]=sc.nextInt();
       }
       long[] dp=new long[n];
       Arrays.fill(dp,Long.MAX_VALUE);
       dp[0]=1L*0;
       if(n==1){
          System.out.println(dp[0]); 
          return;
       }
       dp[1]=1L*nums[0]*nums[1];
       if(n==2){
          System.out.println(dp[1]); 
          return;
       }
       for(int i=2;i<n;i++){
           for(int jump=k;jump>=1;jump--){
               if(i-jump>=0){
                   dp[i]=Math.min(dp[i],dp[i-jump]+1L*nums[i-jump]*nums[i]);
               }
           }
       }
        System.out.println(dp[n-1]); 
  }
}
