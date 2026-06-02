/*
| Approach                                                                                                                                        | Time     | Space    |
| ----------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use a frequency map to pair words with their reverses, count symmetric words separately, and optionally place one symmetric word in the center. | **O(N)** | **O(N)** |

*/
class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        int ans=0;
        int temp=0;
        for(int i=0;i<n;i++){
            String original=words[i];
            String reverse=""+original.charAt(1)+original.charAt(0);
            if(original.equals(reverse)){
                if(map.getOrDefault(reverse,0)>=2){
                    ans=ans+4;
                    int f=map.get(reverse)-2;
                    if(f==0) map.remove(reverse);
                    else map.put(reverse,f);
                }else if(map.getOrDefault(reverse,0)==1){
                    temp=2;
                }
            }else  if(map.containsKey(reverse)){
                    ans=ans+2;
                    int f=map.get(reverse)-1;
                    if(f==0) map.remove(reverse);
                    else map.put(reverse,f);
            }
           
        }
        return ans+temp;
    }
}
