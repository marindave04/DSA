/*
Problem Link:https://www.codechef.com/problems/TADELIVE?tab=statement
*/
/*
| Approach                                                                                                                              | Time           | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Compute profit differences `(A[i]-B[i])`, sort them, build suffix sums, and try all valid counts of choosing from arrays `A` and `B`. | **O(N log N)** | **O(N)** |

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int X=sc.nextInt();
		int Y=sc.nextInt();
		int[] A =new int[N];
		int[] B=new int[N];
		for(int i=0;i<N;i++){
		    A[i]=sc.nextInt();
		}
		long sum=0;
		for(int i=0;i<N;i++){
		    B[i]=sc.nextInt();
		    sum=(long) sum+B[i];
		}
	    int[] C=new int[N];
	    for(int i=0;i<N;i++){
	        C[i]=A[i]-B[i];
	    }
	    Arrays.sort(C);
	    long[] p=new long[N];
	    p[N-1]=C[N-1];
	    for(int i=N-2;i>=0;i--){
	        p[i]=(long)p[i+1]+C[i];
	    }
        //We will try all possible combination of X and Y such that X+Y=N;
        int x=0;
        int y=N-1;
        long max=0;
        while(y>=0){
            if(x<=X && y<=Y){
                long variable=0;
                if(x!=0) variable=p[N-x];
                long newSum=(long)sum+variable;
                max=Math.max(max,newSum);
            }
            x++;
            y--;
        }
        System.out.println(max);
	}
}
