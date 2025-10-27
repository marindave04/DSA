class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> list=new ArrayList<>();
        
        generate(n,"",list);
        return list;
    }
    static void generate(int n,String current,ArrayList<String> list){
        if(current.length()==n){
            list.add(current);
            return;
        }
        
        generate(n,current+"0",list);
        generate(n,current+"1",list);
    }
}
