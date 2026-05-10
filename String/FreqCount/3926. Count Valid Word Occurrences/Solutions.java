/*
| Approach                                                                                                                                        | Time         | Space               |
| ----------------------------------------------------------------------------------------------------------------------------------------------- | ------------ | ------------------- |
| Concatenate all chunks, extract valid lowercase/hyphen words while scanning, store counts in hashmap, then answer queries using hashmap lookup. | **O(n + q)** | **O(unique words)** |

*/
class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
       StringBuilder sb=new StringBuilder();
       for(String str:chunks){
        sb.append(str);
       }
       //we will start building the valid substring 
       int i=0;
       int n=sb.length();
       HashMap<String,Integer> map=new HashMap<>();
       while(i<n){
        char ch=sb.charAt(i);
        if(!Character.isLowerCase(ch)){
            i++;
            continue;
        }
        StringBuilder word=new StringBuilder();
        while(i<n){
            char ch1=sb.charAt(i);
            if(Character.isLowerCase(ch1)){
                word.append(ch1);
                i++;
            }else if(ch1=='-' && i>0 && i<n-1 && Character.isLowerCase(sb.charAt(i-1)) && Character.isLowerCase(sb.charAt(i+1)) ){
                word.append(ch1);
                i++;
            }else{
                i++;
                break;
            }
        }
         String s=word.toString();
         map.put(s,map.getOrDefault(s,0)+1);
       }
       int m=queries.length;
       int[] ans=new int[m];
       for(int j=0;j<m;j++){
        if(map.containsKey(queries[j])){
            ans[j]=map.get(queries[j]);
        }
       }
       return ans;
    }
}
