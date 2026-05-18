/*
| Approach                                                                                                                                  | Time           | Space    |
| ----------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Use sliding window with `TreeMap` to maintain current minimum and maximum characters, shrinking window when their difference exceeds `k`. | **O(N log N)** | **O(N)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int k=sc.nextInt();
   String s=sc.next();
   TreeMap<Character,Integer> set=new TreeMap<>();
   int i=0;
   int j=0;
   int diff=0;
   int max=0;
   while(j<n){
       char ch=s.charAt(j);
       set.put(ch,set.getOrDefault(ch,0)+1);
       diff=set.lastKey()-set.firstKey();
       if(diff>k){
            char left=s.charAt(i);
            if(set.get(left)==0) set.remove(left);
            diff=set.lastKey()-set.firstKey();
            i++;
       }
       max=Math.max(max,j-i+1);
       j++;
   }
   System.out.println(max);
  }
}
