class Solution {
    public String makeLargestSpecial(String s) {
        List<String> ans=new ArrayList<>();
        int sum=0;
        int st=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                sum+=1;
            }else{
                sum-=1;
            }
            if(sum==0){
                String inner=s.substring(st+1,i);
                String temp="1"+makeLargestSpecial(inner)+"0";
                ans.add(temp);
                st=i+1;
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        StringBuilder result=new StringBuilder();
        for(String str:ans){
            result.append(str);
        }
        return result.toString();
    }
}
