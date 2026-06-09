/*
Problem Link:https://www.desiqna.in/18789/salesforce-oa-dsa-41lpa-may-2025-kumar-k
*/
/*
| Approach                                                                                                                                              | Time     | Space    |
| ----------------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Transform elements relative to `nums[k]` (`-1`, `0`, `1`), use prefix sums and separate frequency maps for even/odd indices to count valid subarrays. | **O(N)** | **O(N)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int k=sc.nextInt();
     int[] nums=new int[n+1];
     for(int i=1;i<n+1;i++){
       nums[i]=sc.nextInt();
      }
      int g=nums[k];
      //Transforfimg the array
       for(int i=1;i<n+1;i++){
         if(nums[i]<g){
             nums[i]=-1;
         }else if(nums[i]>g){
             nums[i]=1;
         }else{
             nums[i]=0;
         }
      }
      HashMap<Long,Long> even=new HashMap<>();
      HashMap<Long,Long> odd=new HashMap<>();
      long sum=0;
      long count=0;
      even.put(0L,1L);
    
      for(int i=1;i<n+1;i++){
          sum+=nums[i];
          if(i%2==0){
              count+=odd.getOrDefault(sum,0L);
              even.put(sum,even.getOrDefault(sum,0L)+1);
          }else{
               count+=even.getOrDefault(sum,0L);
              odd.put(sum,odd.getOrDefault(sum,0L)+1);
          }
      }
    System.out.println(count);
  }
}
