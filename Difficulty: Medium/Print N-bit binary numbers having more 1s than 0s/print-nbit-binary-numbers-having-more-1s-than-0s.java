// User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
         ArrayList<String> list=new ArrayList<>();
         solve("1",N,list);
         Collections.sort(list, Collections.reverseOrder());
         return list;
    }
    static void solve(String s,int n,ArrayList<String> list){
        if(s.length()==n){
            if(check(s)){
                list.add(s);
            }
            return;
        }
        solve(s+'0',n,list);
        solve(s+'1',n,list);
    }
    static boolean check(String s){
        int l=1;
        // int count1=0;
        // int count0=0;
        boolean temp=true;
        while(l<=s.length()){
            int count1=0;
            int count0=0;
            for(int i=0;i<l;i++){
                if(s.charAt(i)=='1') count1++;
                if(s.charAt(i)=='0') count0++;
            }
            if(count1<count0) temp=false;
            l++;
        }
        return temp;
    }
}