class Solution {
    public int countBinarySubstrings(String s) {
        int[] temp=new int[s.length()];
        temp[0]=1;
        int k=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                temp[k]++;
             
            }else{
                k++;
                temp[k]=1;
            }
        }
        int count=0;
        for(int i=0;i<k;i++){
            count+=Math.min(temp[i],temp[i+1]);
        }
        return count;
    }
}
