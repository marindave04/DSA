/*
| Approach                                              | Time Complexity  | Space Complexity |
| ----------------------------------------------------- | ---------------- | ---------------- |
| **BFS (Level-wise Mutation Generation with HashSet)** | **O(n × 8 × 4)** | **O(n)**         |

*/
class Solution {
    public int minMutation(String s, String e, String[] bank) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> visited=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            set.add(bank[i]);
        }
        Queue<String> q=new LinkedList<>();
        q.offer(s);
        visited.add(s);
        int level=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                String curr=q.poll();
                if(curr.equals(e)) return level;
                geneForm(curr,set,q,visited);
            }
            level++;
        }
        return -1;
    }
    static void geneForm(String curr,HashSet<String> set,Queue<String> q,HashSet<String> visited){
        StringBuilder sb=new StringBuilder(curr);
        char[] ch={'A','C','G','T'};
        for(char c:ch){
            for(int i=0;i<8;i++){
                char temp=sb.charAt(i);
                if(temp==c) continue;
                sb.setCharAt(i,c);
                if(set.contains(sb.toString()) && !visited.contains(sb.toString())){
                    q.add(sb.toString());
                    visited.add(sb.toString());
                }
                sb.setCharAt(i,temp);
            }
        }
    }
}
