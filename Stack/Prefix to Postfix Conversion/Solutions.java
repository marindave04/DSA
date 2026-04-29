/*
| Approach                                                                                                                         | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse prefix from right to left, push operands, on operator pop two expressions and combine as operand1 + operand2 + operator | **O(n)**        | **O(n)**         |

*/
// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        int n=pre_exp.length();
        for(int i=n-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                String s=ch+"";
                st.push(s);
            }else{
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<2;j++){
                    sb.append(st.pop());
                }
                sb.append(ch);
                st.push(sb.toString());
            }
        }
        return st.peek();
    }
}
