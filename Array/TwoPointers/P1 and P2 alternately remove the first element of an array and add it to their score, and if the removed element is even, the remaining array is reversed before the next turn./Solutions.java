/*
| Approach                                                                                                                       | Time     | Space    |
| ------------------------------------------------------------------------------------------------------------------------------ | -------- | -------- |
| Simulate the game using two pointers and a reverse flag; players pick elements from front/back depending on current direction. | **O(N)** | **O(1)** |

*/
import java.util.*;
public class MyClass {
    static int solve(int[] nums){
        int turn=1;
        int p1=0;
        int p2=0;
        boolean reversed =false;
        int s=0;
        int n=nums.length;
        int e=n-1;
        while(s<=e){
            if(turn%2!=0){
                if(!reversed){
                    p1=p1+nums[s];
                    if(nums[s]%2==0) reversed=(!reversed);
                    s++;
                }else{
                     p1=p1+nums[e];
                      if(nums[e]%2==0) reversed=(!reversed);
                      e--;
                }
                
            }else{
                 if(!reversed){
                    p2=p2+nums[s];
                    if(nums[s]%2==0) reversed=(!reversed);
                    s++;
                }else{
                     p2=p2+nums[e];
                      if(nums[e]%2==0) reversed=(!reversed);
                      e--;
                }
               
            }
            turn++;
        }
        return Math.abs(p1-p2);
    }
  public static void main(String args[]) {
       int[] nums={2,3,9,4,1,2};
       System.out.println(solve(nums));
  }
}
