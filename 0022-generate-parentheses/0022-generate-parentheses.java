class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list= new ArrayList<>();
        generate(n,"",list);
        return list;
    }
    static void generate(int n,String current, ArrayList<String> list){
        if(current.length()==2*n){
            if(Valid(current)){
                list.add(current);
                return;
            }else{
                return;
            }
        }
        generate(n,current+"(",list);
        generate(n,current+")",list);
    }
     static boolean Valid(String str) {
        int sum = 0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                sum +=1;
            }else{
                sum -=1;
                if(sum<0) return false;
            }
        }
        return sum == 0;
    }
    }
