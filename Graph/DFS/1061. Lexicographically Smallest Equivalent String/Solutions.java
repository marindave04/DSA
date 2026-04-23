/*
| Approach                                 | Time Complexity | Space Complexity |
| ---------------------------------------- | --------------- | ---------------- |
| DFS (Adjacency List + DFS per character) | O(m × n)        | O(n)             |

*/

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character,List<Character>> adj=new HashMap<>();
        for(int i=0;i<s1.length();i++){
           char u=s1.charAt(i);
           char v=s2.charAt(i);
           adj.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
           adj.computeIfAbsent(v,k-> new ArrayList<>()).add(u);
        }
        String str="";
        for(int i=0;i<baseStr.length();i++){
            HashSet<Character> vis=new HashSet<>();
            char ch=dfs(adj,baseStr.charAt(i),vis);
            str=str+ch;
        }
        return str;
    }
    static char dfs(Map<Character,List<Character>> adj,char src,HashSet<Character> vis){
        vis.add(src);
        char min=src;
        if(!adj.containsKey(src)) return src;
        for(char v:adj.get(src)){
            if(!vis.contains(v)){
                char res=dfs(adj,v,vis);
                if(res<min){
                    min=res;
                }
            }
        }
        return min;
    }
}
