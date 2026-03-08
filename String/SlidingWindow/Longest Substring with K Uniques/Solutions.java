class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int n=s.length();
        int max=-1;
        while(j<n){
            
            while(j<n && map.size()>k){
                
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==k){
                max=Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }
}
