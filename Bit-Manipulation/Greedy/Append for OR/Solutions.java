/https://www.codechef.com/problems/APPENDOR?tab=statement/
/*
| Approach                                                                                                                 | Time          | Space    |
| ------------------------------------------------------------------------------------------------------------------------ | ------------- | -------- |
| Compute bitwise OR of all elements, then compare bits of result with `k` to build required mask or detect impossibility. | **O(N + 61)** | **O(1)** |

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0){
	     int n=sc.nextInt();
	     int k=sc.nextInt();
	     int y=0;
	     int[] nums=new int[n];
	     for(int i=0;i<n;i++){
	         nums[i]=sc.nextInt();
	         y=y|nums[i];
	     }
	     int mask=0;
   int d=0;
   for(int i=60;i>=0;i--){
       int start=0;
       int g=(y>>i);
       if((g & 1) ==1){
           start=1;
       }else {
           start=0;
       }
       int f=0;
       g=(k>>i);
       if((g & 1 )==1){
           f=1;
       }else {
           f=0;
       }
       if(start==f){
           continue;
       }else {
           if(start==0){
               mask=mask|(1<<i);//ading 2^i
           }else{
               d=-1;
           }
       }
   }
   if(d==-1){
        System.out.println(-1);
   }else{
        System.out.println(mask);
   }
	 }

	}
}
