class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        int i=0;
        boolean temp=false;
        while(i<n){
            if(bits[i]==0){
                temp=true;
                i++;
            }else if(bits[i]==1){
                temp=false;
                i=i+2;
            }
        }
        return temp;
    }
}