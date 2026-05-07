/*
| Approach                                                                                                                                                  | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse postfix expression left to right, push operands into stack, and on operator pop two expressions then combine as `operator + operand2 + operand1` | **O(n)**        | **O(n)**         |

*/
class Solution {
    static String postToPre(String s) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String str=ch+"";
            if(Character.isLetterOrDigit(ch)){
                st.push(str);
            }else{
                String top1=st.pop();
                String top2=st.pop();
                String temp=ch+top2+top1;
                st.push(temp);
            }
        }
        return st.peek();
    }
}
