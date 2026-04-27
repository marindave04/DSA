/*
| Approach                                                                                                                        | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse prefix from right to left, push operands in stack, on operator pop two strings and form infix expression with brackets | **O(n)**        | **O(n)**         |

*/
// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        int n=pre_exp.length();
        for(int i=n-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            String str=""+ch;
            if(Character.isLetterOrDigit(ch)){
                st.push(str);
            }else{
                StringBuilder sb=new StringBuilder();
                sb.append('(');
                 sb.append(st.pop());
                 sb.append(ch);
                  sb.append(st.pop());
                   sb.append(')');
                   st.push(sb.toString());
            }
        }
        return st.peek();
    }
}
