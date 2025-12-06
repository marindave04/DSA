// User function Template for Java

class Solution {
    private ArrayList<String> list=new ArrayList<>();
    ArrayList<String> NBitBinary(int N) {
        // code here
        solve(N,0,1,"1");
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
    private void solve(int n,int count0,int count1,String s){
        if(s.length()==n){
            list.add(s);
            return;
        }
        if(count0<count1){
            solve(n,count0+1,count1,s+"0");
             
        }
        solve(n,count0,count1+1,s+"1");
        
    }
}