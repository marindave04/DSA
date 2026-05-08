/*
| Approach                                                                                                                                                     | Time Complexity | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------ | --------------- | ---------------- |
| Traverse postfix expression left to right, push operands into stack, and on operator pop two expressions then combine them as `(operand1 operator operand2)` | **O(n)**        | **O(n)**         |

*/
class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }else{
                String top1=st.pop();
                String top2=st.pop();
                String temp='('+top2+ch+top1+')';
                st.push(temp);
            }
        }
        return st.peek();
    }
}
