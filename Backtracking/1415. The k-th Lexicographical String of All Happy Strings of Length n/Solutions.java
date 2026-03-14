/*
| Approach                                                        | Time Complexity | Space Complexity |
| --------------------------------------------------------------- | --------------- | ---------------- |
| **Backtracking (Generate all Happy Strings and store in list)** | **O(2ⁿ)**       | **O(2ⁿ)**        |

*/
class Solution {

    public String getHappyString(int n, int k) {
        
       char[] a=new char[3];
       a[0]='a';
       a[1]='b';
       a[2]='c';
       ArrayList<String> list=new ArrayList<>();
        solve(new StringBuilder(),a,n,list);
        if(k>list.size()) return "";
        return list.get(k-1); 
    }
    static void solve(StringBuilder sb,char[] a,int n, ArrayList<String> list){
        if(sb.length()==n){
           list.add(sb.toString());
           return;
        }
        for(int i=0;i<3;i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==a[i]) continue;
             solve(sb.append(a[i]),a,n,list);
             sb.deleteCharAt(sb.length() - 1);
        }
       
    } 
}
/*
| Approach                                                                       | Time Complexity          | Space Complexity |
| ------------------------------------------------------------------------------ | ------------------------ | ---------------- |
| **Backtracking with Early Stopping (Generate Happy Strings until k-th found)** | **O(2ⁿ)** *(worst case)* | **O(n)**         |

*/
class Solution {

    public String getHappyString(int n, int k) {
        
       char[] a=new char[3];
       String[] ans=new String[1];
       int[] count=new int[1];
       a[0]='a';
       a[1]='b';
       a[2]='c';
     
        solve(new StringBuilder(),a,n,ans,count,k);
       if(ans[0]==null) return "";
       return ans[0];
    }
    static void solve(StringBuilder sb,char[] a,int n,String[] ans,int[] count,int k){
        if(sb.length()==n){
           count[0]++;
           if(count[0]==k){
            ans[0]=sb.toString();
           }
           return;
        }
        for(int i=0;i<3;i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==a[i]) continue;
             solve(sb.append(a[i]),a,n,ans,count,k);
             if(ans[0]!=null) return;
             sb.deleteCharAt(sb.length() - 1);
        }
       
    } 
}
