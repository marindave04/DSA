/*
https://www.desiqna.in/18756/goldman-sachs-oa-2025-set-3-dancing-penguins
*/
/*
| Approach                                                                                                                           | Time           | Space    |
| ---------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Separate positive and negative heights, sort the groups, then use two-pointer greedy matching to maximize valid male-female pairs. | **O(N log N)** | **O(N)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] f=new int[n];
    int[] m=new int[n];
    for(int i=0;i<n;i++){
        m[i]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
        f[i]=sc.nextInt();
    }
    ArrayList<Integer> p1m=new ArrayList<>();//this will store pos male heights
    ArrayList<Integer> p2m=new ArrayList<>();//this will store neg male heights
    ArrayList<Integer> p1f=new ArrayList<>();//this will store pos female heights
    ArrayList<Integer> p2f=new ArrayList<>();//this will store neg female heights
    for(int i=0;i<n;i++){
        if(m[i]>0){
            p1m.add(m[i]);
        }else{
             p2m.add(Math.abs(m[i]));
        }
        if(f[i]>0){
             p1f.add(f[i]);
        }else{
             p2f.add(Math.abs(f[i]));
        }
    }
    Collections.sort(p1m);
    Collections.sort(p2m);
    Collections.sort(p1f);
    Collections.sort(p2f);
    int i=0;
    int j=0;
    int count=0;
    while(i<p1m.size() && j<p2f.size()){
        if(p2f.get(j)>p1m.get(i)){
            i++;
            j++;
            count++;
        }else{
            j++;
        }
    }
    i=0;
    j=0;
    while(j<p2m.size() && i<p1f.size()){
        if(p1f.get(i)<p2m.get(j)){
            i++;
            j++;
            count++;
        }else{
            j++;
        }
    }
    System.out.println(count);
  }
}
