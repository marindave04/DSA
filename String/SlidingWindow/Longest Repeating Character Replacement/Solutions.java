/*
| Approach                                                                                                                        | Time Complexity | Space Complexity     |
| ------------------------------------------------------------------------------------------------------------------------------- | --------------- | -------------------- |
| Try every substring using three nested loops, build frequency map, track max repeating character, and validate replacements ≤ k | **O(n³)**       | **O(26)** / **O(1)** |

*/
class Solution {
    public int longestSubstr(String s, int k) {
        // code here
       
        int n=s.length();
     
        int max=1;
        for(int i=0;i<n;i++){
            int maxFreq=0;
            for(int j=i;j<n;j++){
                HashMap<Character,Integer> map=new HashMap<>(); 
                for(int t=i;t<=j;t++){
                    char ch=s.charAt(t);
                    map.put(ch,map.getOrDefault(ch,0)+1);
                 
                maxFreq=Math.max(maxFreq,map.get(ch));
                int length=j-i+1;
                if(Math.abs(length-maxFreq)<=k){
                    max=Math.max(max,length);
                }
                }
        }
        }
        return max;
    }
}
/*
| Approach                                                                                                                         | Time Complexity | Space Complexity     |
| -------------------------------------------------------------------------------------------------------------------------------- | --------------- | -------------------- |
| Use sliding window with frequency array, maintain highest occurring character, shrink window when replacements needed exceed `k` | **O(n)**        | **O(26)** / **O(1)** |

*/
class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        int n=s.length();
        int max=1;
        int i=0;
        int j=0;
        int[] f=new int[26];
        int maxFreq=0;
        while(j<n){
            char ch=s.charAt(j);
            f[ch-'A']++;
            int length=j-i+1;
            maxFreq=Math.max(maxFreq,f[ch-'A']);
            while(Math.abs(length-maxFreq)>k){
                 char ch1=s.charAt(i);
                 f[ch1-'A']--;
                 i++;
                 length=j-i+1;
            }
            if(Math.abs(length-maxFreq)<=k){
                max=Math.max(max,length);
            }
            j++;
        }
        return max;
    }
}
