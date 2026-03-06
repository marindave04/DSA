class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1 && s.charAt(0)=='1') return true;
        int count=0;
        int i=0;
        
        while(i<s.length()){
           if(s.charAt(i)=='1'){
            count++;
            while(i<s.length() && s.charAt(i)=='1' ){
                i++;
            }
           
           }else{
            i++;
           }
        }
        
        if(count>1) return false;
        return true;
    }
}
