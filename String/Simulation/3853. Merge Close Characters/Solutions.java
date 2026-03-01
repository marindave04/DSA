class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            char ch1=sb.charAt(i);
            for(int j=i+1;j<sb.length();j++){
                char ch2=sb.charAt(j);
                if(ch1==ch2){
                    if(j-i<=k){
                        sb.deleteCharAt(j);
                        i=-1;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
