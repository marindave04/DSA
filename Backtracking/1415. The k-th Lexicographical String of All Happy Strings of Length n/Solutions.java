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
