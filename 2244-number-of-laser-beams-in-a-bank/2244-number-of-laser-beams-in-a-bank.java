class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int count=0;
        int temp=0;
        int prev=0;
        for(int i=0;i<n-1;i++){
            int cr=ones(bank[i]);
            for(int j=i+1;j<n;j++){
                int nr=ones(bank[j]);
                if(j>i+1 && prev>0){
                    continue;
                }else{
                    temp=cr*nr;
                    count=count+temp;
                    prev=nr;
                }
            }
        }
       return count;
    }
    static int ones(String a){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='1') count++;
        }
        return count;
    }
}