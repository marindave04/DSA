class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        int size=(int)Math.pow(2,n)-1;
        int mid=size/2+1;
        if(k==mid) return '1';
        if(k<mid) return findKthBit(n-1,k);
        char ch='#';
        if(k>mid){
            ch=findKthBit(n-1,mid-(k-mid));
             if(ch=='0') return '1';
             else return '0';
        }
       
         return '0';
        
    }
}
