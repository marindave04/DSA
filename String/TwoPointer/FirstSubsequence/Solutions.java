/*
Problem Link:-https://www.desiqna.in/17545/google-oa-first-subsequence-13th-july
*/
/*
| Approach                                                                                                                                                | Time              | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------- | -------- |
| Try replacing each character of `b` (except the first), check all 26 lowercase letters, and verify whether the modified string is a subsequence of `a`. | **O(26 · M · N)** | **O(M)** |

*/
import java.util.*;
public class MyClass {
    static int idx=-1;
     public static  boolean isSubsequence(String s, String t) {
        int n=s.length();
        int r=t.length();
        int i=0;
        int j=0;
        int count=0;
        while(i<n && j<r){
            char ch1=s.charAt(i);
            char ch2=t.charAt(j);
            if(ch1==ch2){
                if(count==0){
                    idx=j;
                }
                i++;
                j++;
                count++;
            }else{
                j++;
            }
        }
        if(n==count) return true;
        return false;
    }
  public static void main(String args[]) {
     Scanner sc=new Scanner(System.in);
     String a=sc.next();
     String b=sc.next();
     int ans=-1;
     for(int i=1;i<b.length();i++){
         for(char c='a';c<='z';c++){
             char[] arr=b.toCharArray();
             arr[i]=c;
             if(isSubsequence(new String(arr),a)){
                 ans=idx+1;
                 System.out.println(ans);
                 return;
             }
         }
     }
     System.out.println(ans);
  }
}
