/*| Approach                                                                                                                       | Time     | Space    |
| ------------------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| Use dynamic programming where each position stores minimum energy needed to reach it using allowed jumps and transition costs. | **O(N)** | **O(N)** |
*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] nums=new int[n];
    for(int i=0;i<n;i++){
        nums[i]=sc.nextInt();
    }
    int[] dp=new int[n];
    dp[0]=0;
    if(n==1){
        System.out.println(dp[0]);
        return;
    }
    dp[1]=Math.abs(nums[1]-nums[0]);
    if(n==2){
        System.out.println(dp[1]);
        return;
    }
     dp[2]=dp[1]+Math.abs(nums[1]-nums[2]);
     if(n==3){
        System.out.println(dp[2]);
        return;
    }
    for(int i=3;i<n;i++){
        dp[i]=Math.min(dp[i-3]+Math.abs(nums[i-3]-nums[i]),dp[i-1]+Math.abs(nums[i-1]-nums[i]));
    }
      System.out.println(dp[n-1]);
  }
}
