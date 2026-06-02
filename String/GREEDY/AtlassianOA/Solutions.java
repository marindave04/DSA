/*
Problem Link:https://www.desiqna.in/17763/atlassian-oa-ctc-75-l-sep-21-kumar-k-q1
*/
/*
| Approach                                                                                                                                      | Time         | Space        |
| --------------------------------------------------------------------------------------------------------------------------------------------- | ------------ | ------------ |
| For each string, check whether it contains any character with an odd ASCII value, count such strings, then determine the parity of the count. | **O(K · L)** | **O(K · L)** |

*/
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int k=sc.nextInt();
    String[] s=new String[k];
    for(int i=0;i<k;i++){
        s[i]=sc.next();
    }
    int odd=0;
    for(int i=0;i<k;i++){
        String str=s[i];
        boolean flagOdd=false;
        for(int j=0;j<str.length();j++){
            int num=(int)str.charAt(j);
            if(num%2!=0){
                flagOdd=true;
                break;
            }
        }
        if(flagOdd) odd++;
    }
    if(odd%2!=0) {
         System.out.println("ODD");
    }else{
        System.out.println("EVEN");
    }
    
  }
}
