class Solution {
    private List<List<String>> ans=new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        boolean[] visited=new boolean[words.length];
        solve(words,visited,new ArrayList<>());
        Collections.sort(ans,(a,b)->{
            for(int i=0;i<a.size();i++){
                int comp=a.get(i).compareTo(b.get(i));
                if(comp!=0) return comp;
            }
            return 0;
        });
        return ans;

    }
    private void solve(String[] words,boolean[] visited,List<String> list){
        if(list.size()==4){
            char[] top=list.get(0).toCharArray();
            char[] left=list.get(1).toCharArray();
            char[] right=list.get(2).toCharArray();
            char[] bottom=list.get(3).toCharArray();
            if((top[0] == left[0] && top[3] == right[0]) && (bottom[0] == left[3] && bottom[3] == right[3]))  ans.add(new ArrayList(list));
           
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!visited[i]){
                list.add(words[i]);
                visited[i]=true;
                solve(words,visited,list);
                visited[i]=false;
                list.remove(list.get(list.size()-1));
            }

        }
    }
}