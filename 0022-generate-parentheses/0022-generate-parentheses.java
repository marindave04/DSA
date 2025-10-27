class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list= new ArrayList<>();
        generate(n,"",list, 0,0);
        return list;
    }
    static void generate(int n,String current, ArrayList<String> list,int open,int close){
        if(current.length()==2*n){
            if(Valid(current)){
                list.add(current);
                return;
            }else{
                return;
            }
            // list.add(current);
            // return;
        }
        if(open<n)generate(n,current+"(",list,open+1,close);
        generate(n,current+")",list,open,close+1);
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
