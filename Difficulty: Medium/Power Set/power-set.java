// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        set(s,"",0);
        Collections.sort(list);
        return list;
    }
    private List<String> list=new ArrayList<>();
    
    private void set(String s,String current,int i){
        if(i>=s.length()){
            list.add(current);
            return;
        }
        
        current +=s.charAt(i);
        set(s,current,i+1);
        current=current.substring(0,current.length()-1);
        set(s,current,i+1);
    }
}