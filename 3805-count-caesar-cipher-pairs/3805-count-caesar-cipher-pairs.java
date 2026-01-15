class Solution {
    public long countPairs(String[] words) {
        int n=words.length;
        int m=words[0].length();
        long count=0;
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            char[] ch=words[i].toCharArray();
            String key="";
             for(int j=0;j<m-1;j++){
              int diff = ((ch[j]-'a')-(ch[j+1]-'a'));
              if(diff<0){
                diff=(diff+26)%26;
              }else {
                diff=(diff)%26;
              }
              key=key+diff;
             }
             map.put(key,map.getOrDefault(key,0)+1);
        }
        for(String key:map.keySet()){
            long freq=(long) map.get(key);
            count=(long)count+(long) freq*(freq-1)/2;
        }
        return count;
    }
}