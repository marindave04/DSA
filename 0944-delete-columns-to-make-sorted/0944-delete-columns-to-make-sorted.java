class Solution {
    public int minDeletionSize(String[] strs) {
        boolean temp=false;
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            int x=strs[0].charAt(i)-'0';
            for(int j=1;j<strs.length;j++){
                if(x<=strs[j].charAt(i)-'0') {
                    temp=true;
                   x=strs[j].charAt(i)-'0';
            }else{
                count++;
                break;
            }
        }
    }
    return count;
}
}