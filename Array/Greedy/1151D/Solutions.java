/*
https://codeforces.com/contest/1151/problem/D
*/
/*
| Approach                                                                                                                               | Time           | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Sort pairs by decreasing difference `(a - b)` so contribution order becomes optimal, then compute total pairwise cost using positions. | **O(N log N)** | **O(1)** |

*/
import java.util.*;
public class Main{
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          long[][] queue=new long[n][2];
          for(int i=0;i<n;i++){
               long a=sc.nextLong();
               long b=sc.nextLong();
               queue[i][0]=a;
               queue[i][1]=b;
          }
          Arrays.sort(queue,(a,b)->{
               long diff1=a[0]-a[1];
               long diff2=b[0]-b[1];
               return Long.compare(diff2, diff1);
          });
          long cost=0;
          for(int j=0;j<n;j++){
               long a= queue[j][0];
               long b= queue[j][1];
               long temp=(long)a*(j-0)+(long)b*(n-j-1);
               cost=(long)cost+temp;
          }
          System.out.println(cost);
     }
}
/*
| Approach                                                                                                                                | Time           | Space    |
| --------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Transform expression using algebra, sort `(a-b)` values, then multiply by positional weights to compute minimum total cost efficiently. | **O(N log N)** | **O(N)** |

*/
import java.util.*;
public class Main{
     public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          long cost1=0;
          long[] A=new long[n+1];
          long[] B=new long[n+1];
          for(int i=1;i<n+1;i++){
               long a=sc.nextLong();
               long b=sc.nextLong();
               cost1=(long)cost1+(long)(b*n-a);
               A[i]=(long)(a-b);
               B[i]=n-i+1;;
          }
          A[0]=Long.MIN_VALUE;
          Arrays.sort(A);
          long cost2=0;
          for(int j=1;j<n+1;j++){
              long temp=(long)A[j]*B[j];
              cost2=(long) cost2+temp;
          }
          long cost=(long) cost1+cost2;
          System.out.println(cost);
     }
}
