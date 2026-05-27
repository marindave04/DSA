/*
Problem:https://atcoder.jp/contests/dp/tasks/dp_c
*/
/*
| Approach                                                                                                                                      | Time     | Space    |
| --------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use dynamic programming where each state stores maximum happiness ending with activity A, B, or C while avoiding consecutive same activities. | **O(N)** | **O(N)** |

*/
import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int[][] nums=new int[N][3];
    for(int i=0;i<N;i++){
      for(int j=0;j<3;j++){
        nums[i][j]=sc.nextInt();
      }
    }
    long[] dpa=new long[N];
    long[] dpb=new long[N];
    long[] dpc=new long[N];
    dpa[0]=(long)nums[0][0];
    dpb[0]=(long)nums[0][1];
    dpc[0]=(long)nums[0][2];
    for(int i=1;i<N;i++){
      dpa[i]=(long)nums[i][0]+(long)Math.max(dpb[i-1],dpc[i-1]);
      dpb[i]=(long)nums[i][1]+(long)Math.max(dpa[i-1],dpc[i-1]);
      dpc[i]=(long)nums[i][2]+(long)Math.max(dpa[i-1],dpb[i-1]);
    }
    long max=(long)Math.max(dpa[N-1],(long)Math.max(dpb[N-1],dpc[N-1]));
    System.out.println(max);
  }
}
