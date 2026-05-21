/*More explanation of Question
 -> DP to find the longest contiguous substring where:
∣s[i]−s[i−1]∣≤k
*/
/*| Approach                                                                                                                            | Time     | Space    |
| ----------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use dynamic programming/sliding extension to track longest contiguous substring where adjacent character difference is at most `k`. | **O(N)** | **O(N)** |
*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
   Scanner sc=new Scanner(System.in);
   String s=sc.next();
   int k=sc.nextInt();
   int n=s.length();
   int[] dp=new int[n];
   dp[0]=1;
   if(n==1){
       System.out.println(dp[0]);
       return;
   }
    int max=1;
    int idx=0;
   for(int i=1;i<n;i++){
       char ch1=s.charAt(i);
       char ch2=s.charAt(i-1);
       int x1=ch1+'a';
       int x2=ch2+'a';
       if(Math.abs(ch1-ch2)<=k){
           dp[i]=dp[i-1]+1;
       }else{
           dp[i]=1;
       }
       if(dp[i]>max){
           max=dp[i];
           idx=i;
       }
   }
   int st=idx-max+1;
   String str=s.substring(st,st+max);
    System.out.println(str);
  }
}
