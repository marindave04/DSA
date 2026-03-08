class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        ArrayList<String> list=new ArrayList<>();
        solve("",list,n);
       for(int i=0;i<list.size();i++){
        String str=list.get(i);
        boolean flag=false;
        for(int j=0;j<nums.length;j++){
           if(str.equals(nums[j])){
            flag=true;
            break;
           }
        }
        if(!flag){
            return str;
        }
       }
       return "";
    }
    static void solve(String str, ArrayList<String> list,int n){
        if(str.length()==n){
             list.add(str);
             return;
        }
        solve(str+'0',list,n);
        solve(str+'1',list,n);
    }
}
