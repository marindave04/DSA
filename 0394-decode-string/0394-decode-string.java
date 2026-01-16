class Solution {
     int i=0;
    public String decodeString(String s) {
        // by recursion 

        return solve(s);
    }
    private String solve(String s){
        StringBuilder sb=new StringBuilder();
        int k=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                i++;
                k=k*10+(ch-'0');
            }else if(ch=='['){
                i++;
                String temp=solve(s);
                for(int j=1;j<=k;j++){
                    sb.append(temp);
                }
                k=0;
            }else if(ch==']'){
                i++;
                return sb.toString();
            }else{
                i++;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}