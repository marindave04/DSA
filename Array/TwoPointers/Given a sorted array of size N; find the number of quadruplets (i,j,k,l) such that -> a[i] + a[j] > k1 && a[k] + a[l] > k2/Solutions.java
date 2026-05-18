/*
| Approach                                                                                                                        | Time      | Space    |
| ------------------------------------------------------------------------------------------------------------------------------- | --------- | -------- |
| For each middle index, count valid left pairs by traversal and valid right pairs using two pointers, then multiply both counts. | **O(N²)** | **O(1)** |

*/
import java.util.*;
public class MyClass {
    static int solve(int[] nums,int k1,int k2){
       int n=nums.length;
       int count=0;
       for(int j=1;j<=n-2;j++){
           int i=j-1;
           int count1=0;
           while(i>=0){
               if (nums[i] + nums[j] > k1) {
                    count1++;
                }
                i--;
           }
           int k=j+1;
           int l=n-1;
           int count2=0;
           while(k<l){
                if(nums[l]+nums[k]>k2){
                   count2=count2+(l-k);
                   l--;
               }else{
                   k++;
               }
           }
           count+=count1*count2;
       }
       return count;
    }
  public static void main(String args[]) {
       int[] nums={1,1,1,1,2,2};
       System.out.println(solve(nums,1,3));
  }
}
