/*
| Approach                                                                                                                                                 | Time          | Space    |
| -------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------- | -------- |
| Process each bit independently, count numbers with bit `0` and `1`, then use combinatorial counting to compute that bit's contribution to the final sum. | **O(32 · N)** | **O(1)** |

*/
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
	     Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int[] nums=new int[n];
      for(int i=0;i<n;i++){
        nums[i]=sc.nextInt();
       }
       int ans=0;
       for(int bit=31;bit>=0;bit--){
       	int c1=0;
       	int c0=0;
       	for(int i=0;i<n;i++){
       		if((nums[i] & (1<<bit))!=0) c1++;
       		else c0++;
       	}
       	ans=ans+((1<<bit)*(c0*c1))+((1<<bit)*(c1*(c1-1)/2));
       }
        System.out.println(ans);
	}
}
