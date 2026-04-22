/*
| Approach                                                                                        | Time Complexity  | Space Complexity            |
| ----------------------------------------------------------------------------------------------- | ---------------- | --------------------------- |
| For each query, compare with every dictionary word and count character differences (≤2 allowed) | **O(q × d × L)** | **O(1)** (excluding output) |

*/
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dictionary.length;j++){
                if(count(queries[i],dictionary[j])<=2){
                      list.add(queries[i]);
                      break;
                }
            }
        }
        return list;
    }
    static int count(String str1,String str2){
        int diff=0;
        int i=0;
        int j=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)!=str2.charAt(j)){
                diff++;
            }
            i++;
            j++;
        }
        return diff;
    }
}
