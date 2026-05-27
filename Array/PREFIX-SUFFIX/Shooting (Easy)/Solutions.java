/*
Problem: https://www.codechef.com/problems/SHOOT0?tab=statement
*/
/*
| Approach                                                                                                                                       | Time         | Space        |
| ---------------------------------------------------------------------------------------------------------------------------------------------- | ------------ | ------------ |
| Build prefix sums and counts for both shot types, then compute left/right movement costs for each position using prefix contribution formulas. | **O(N · M)** | **O(N · M)** |

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int N=sc.nextInt();
		    int M=sc.nextInt();
		    int[][] nums=new int[N+1][M+1];
		    for(int i=1;i<M+1;i++){
		        nums[N][i]=sc.nextInt();
		    }
		    long[][] p1=new long[N+1][M+1];
		    long[][] p2=new long[N+1][M+1];
		    long[][] c1=new long[N+1][M+1];
		    long[][] c2=new long[N+1][M+1];
		    for(int i=1;i<M+1;i++){
		        if(nums[N][i]==1 || nums[N][i]==3){
		            p1[N][i]=(long)p1[N][i-1]+i;
		            c1[N][i]=(long)c1[N][i-1]+1;
		        }else{
		            p1[N][i]=(long)p1[N][i-1];
		             c1[N][i]=(long)c1[N][i-1];
		        }
		    }
		    for(int i=1;i<M+1;i++){
		        if(nums[N][i]==2 || nums[N][i]==3){
		            p2[N][i]=(long)p2[N][i-1]+i;
		            c2[N][i]=(long)c2[N][i-1]+1;
		        }else{
		            p2[N][i]=(long)p2[N][i-1];
		             c2[N][i]=(long)c2[N][i-1];
		        }
		    }
		    long[][] arsi=new long[N+1][M+1];
		    long[][] krypto=new long[N+1][M+1];
		    for(int i=1;i<M+1;i++){
		        //going left and looking arsi's shot
		        long left=(long)i*c1[N][i-1]-(long)p1[N][i-1];
		        //going right and looking arsi's shot
		        long right=(long)(p1[N][M]-p1[N][i])-(long)i*((long)c1[N][M]-c1[N][i]);
		        arsi[N][i]=(long)left+right;
		    }
		     for(int i=1;i<M+1;i++){
		        //going left and looking KRYPTO shot
		        long left=(long)i*c2[N][i-1]-(long)p2[N][i-1];
		        //going right and looking krypto's shot
		        long right=(long)(p2[N][M]-p2[N][i])-(long)i*((long)c2[N][M]-c2[N][i]);
		       
		        krypto[N][i]=(long)left+right;
		    }
		    long[][] result=new long[N+1][M+1];
		    for(int i=1;i<M+1;i++){
		        result[N][i]=Math.abs(arsi[N][i]-krypto[N][i]);
		    }
		   
		   for(int i=1;i<M+1;i++){
		       System.out.print(result[N][i]+" ");
		   }
		   System.out.println();
		}

	}
}
