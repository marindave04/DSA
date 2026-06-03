/*
| Approach                                                                                                                                   | Time     | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| Traverse the array once, maintain the count of `1`s seen so far, and update the answer based on whether the current element is `0` or `1`. | **O(N)** | **O(1)** |

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
      int count1=0;
      if(nums[0]==1) count1++;
      int sum=0;
      for(int i=1;i<n;i++){
      	if(nums[i]==0){
      		sum+=count1;
      	}else{
      		count1++;
      		sum+=i;
      	}
      }
       System.out.println(sum);
	}
}
/*| Approach                                                                                                          | Time     | Space    |
| ----------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Count the number of `0`s and `1`s, then use combinatorial formulas to count valid pairs without enumerating them. | **O(N)** | **O(1)** |
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
    int count0=0;
    int count1=0;
    for(int i=0;i<n;i++){
        if(nums[i]==0) count0++;
        else count1++;
    }
    int ans=count0*count1;
    int temp=count1*(count1-1)/2;
    System.out.println(temp+ans);
  }
}
