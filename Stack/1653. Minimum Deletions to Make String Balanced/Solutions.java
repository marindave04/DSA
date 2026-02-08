class Solution {
    public int minimumDeletions(String s) {
       int n=s.length();
       Stack<Character> st=new Stack<>();
       int del=0;
      int i=0;
      while(i<n){
        char ch=s.charAt(i);
        if(st.isEmpty()){
            st.push(ch);
            i++;
        }else if(st.peek()=='b' && ch=='a'){
            del++;
            st.pop();
            i++;
        }else{
            st.push(ch);
            i++;
        }
      }
      return del;
    }
}
