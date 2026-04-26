/*
| Approach                                                                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Traverse infix expression, use stack for operators/parentheses based on precedence, build postfix string | **O(n)**        | **O(n)**         |

*/
class Solution {
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() && st.peek()!='(' && (prec(st.peek())>prec(ch) || (prec(st.peek())==prec(ch) && st.peek()!='^'))){
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
    static int prec(char ch){
        if(ch=='^') return 3;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='+' || ch=='-') return 1;
        return -1;
    }
}
