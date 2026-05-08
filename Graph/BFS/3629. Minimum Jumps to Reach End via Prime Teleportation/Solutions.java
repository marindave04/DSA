/*
| Approach                                                                                                                                                                        | Time Complexity                                        | Space Complexity |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------ | ---------------- |
| Use BFS from index `0`; from each position move to adjacent indices and, if current value is prime, jump to indices containing its multiples using hashmap-based index grouping | **O(n + max log log max + total multiple traversals)** | **O(n + max)**   |

*/
class Solution {
    public int minJumps(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        boolean[] prime=new boolean[max+1];
        for(int i=0;i<=max;i++){
            if(isPrime(i)){
                prime[i]=true;
            }else{
                prime[i]=false;
            }
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.putIfAbsent(nums[i],new ArrayList<>());
           map.get(nums[i]).add(i);
        }
        boolean[] visited=new boolean[nums.length];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        int jump=0;
        HashSet<Integer> seen=new HashSet<>();
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                int u=q.poll();
                if(u==nums.length-1) return jump;
                if(u-1>=0 && !visited[u-1]){
                    q.add(u-1);
                    visited[u-1]=true;
                }
                 if(u+1<nums.length && !visited[u+1]){
                    q.add(u+1);
                    visited[u+1]=true;
                }
                if(!prime[nums[u]] || seen.contains(nums[u])) continue;
                seen.add(nums[u]);
                for(int multiple=nums[u];multiple<=max;multiple+=nums[u]){
                        if(map.containsKey(multiple)){
                            for(int x:map.get(multiple)){
                                if(!visited[x]){
                                    q.add(x);
                                    visited[x]=true;
                                }
                            }
                        }
                        
                    }
            }
            jump++;
        }
        return jump;
    }
    static boolean isPrime(int n){
        if(n==0) return false;
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
