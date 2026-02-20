class Solution {
    public String findLargest(int[] arr) {
        // code here
        ArrayList<String> temp=new ArrayList<>();
        for(int num:arr){
            temp.add(Integer.toString(num));
        }
        Collections.sort(temp,(s1,s2)->myCompare(s1,s2) ? -1 : 1);
        if(temp.get(0).equals("0")) return "0";
        StringBuilder result=new StringBuilder();
        for(String str:temp){
            result.append(str);
        }
        return result.toString();
    }
    static boolean myCompare(String s1,String s2){
        return (s1+s2).compareTo(s2+s1)>0;
    }
}
