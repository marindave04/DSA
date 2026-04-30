/*
| Approach                                                                                                                                                                                 | Time Complexity | Space Complexity                |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ------------------------------- |
| Use sliding window with HashMap frequency count, expand `j`, and whenever duplicate character appears shrink from `i` until all characters become unique, tracking maximum window length | **O(n)**        | **O(k)** (at most unique chars) |

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int n=s.length();
        int i=0;
        int j=0;
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)<=1){
                max=Math.max(max,j-i+1);
            }
            while(map.get(ch)>1){
                char ch1=s.charAt(i);
                int f=map.get(ch1);
                f--;
                map.put(ch1,f);
                if(map.get(ch1)==0){
                    map.remove(ch1);
                }
                i++;
            }
            j++;
        }
        return max;
    }
}
