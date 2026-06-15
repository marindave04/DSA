/*| Approach                                                                                                                                                           | Time                       | Space        |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------------------------- | ------------ |
| Use a sweep-line algorithm: treat lamp starts, query points, and lamp ends as events, sort them, then maintain the number of active lamps while processing events. | **O((N + T) log (N + T))** | **O(N + T)** |
*/
/*
Problem Link: https://www.desiqna.in/16114/visa-oa-sde-intern-ctc-30-lac-27th-oct
*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
   Scanner sc = new Scanner(System.in);
   int n=sc.nextInt();
   int t=sc.nextInt();
   int[][] lamps = new int[n][2];
   int[] points=new int[t];
   for(int i=0;i<n;i++){
       lamps[i][0]=sc.nextInt();
        lamps[i][1]=sc.nextInt();
   }
   for(int i=0;i<t;i++){
       points[i]=sc.nextInt();
   }
   ArrayList<int[]> pairs=new ArrayList<>();
   for(int i=0;i<n;i++){
       pairs.add(new int[]{lamps[i][0],0});
        pairs.add(new int[]{lamps[i][1],2});
   }
   for(int i=0;i<t;i++){
       pairs.add(new int[]{points[i],1});
   }
   pairs.sort((a,b)->{
       if(a[0]!=b[0]){
           return Integer.compare(a[0],b[0]);
       }
        return Integer.compare(a[1],b[1]);
   });
    HashMap<Integer,Integer> g=new HashMap<>();
   int c=0;
   for(int i=0;i<pairs.size();i++){
       int first=pairs.get(i)[0];
       int second=pairs.get(i)[1];
       if(second==0){
           c++;
       }else if(second==1){
           g.put(first,c);
       }else{
           c--;
       }
   }
    int[] ans=new int[t];
   
    for(int i=0;i<t;i++){
      ans[i]=g.get(points[i]);
   }
    System.out.println(Arrays.toString(ans));
  }
}
