/*
| Approach                                            | Time Complexity   | Space Complexity |
| --------------------------------------------------- | ----------------- | ---------------- |
| **BFS (Word Ladder with Character Transformation)** | **O(N × L × 26)** | **O(N)**         |

*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;
            HashMap<String,Boolean> vmap=new HashMap<>();
            for(int i=0;i<wordList.size();i++){
                vmap.put(wordList.get(i),false);
            }
            Queue<String> q=new LinkedList<>();
            q.offer(beginWord);
            vmap.put(beginWord,true);
            int level=1;
            while(!q.isEmpty()){
                int lsize=q.size();
                for(int i=0;i<lsize;i++){
                    String temp=q.poll();
                    if(temp.equals(endWord)) return level;
                    word(temp,vmap,q);
                }
                level++;
            }
            return 0;
    }
    static void word(String temp, HashMap<String,Boolean> vmap,Queue<String> q){
        for(int i=0;i<temp.length();i++){
            char[] arr=temp.toCharArray();
            for(int j=0;j<26;j++){
                char ch=(char)('a'+j);
                arr[i]=ch;
                String s=String.valueOf(arr);
                if(vmap.containsKey(s) && !vmap.get(s)){
                    q.offer(s);
                    vmap.put(s,true);
                }
            }
        }
    }
}
