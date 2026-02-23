class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n-k+1;i++){
            String str=s.substring(i,k+i);
            set.add(str);
        }
        int x=(int)Math.pow(2,k);
        if(x==set.size()) return true;
        return false;
    }
}
