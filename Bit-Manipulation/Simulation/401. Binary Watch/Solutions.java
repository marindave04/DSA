class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans=new ArrayList<>();
        for(int h=0;h<=11;h++){
            for(int m=0;m<=59;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==turnedOn){
                    String x=String.valueOf(h);
                    String y=(m<10 ? "0" : "")+m;
                    ans.add(x+":"+y);
                }
            }
        }
        return ans;
    }
}
