class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int i=0;
        int j=0;
        
        int index=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           if(j-i+1==k){
          PriorityQueue<Map.Entry<Integer, Integer>> pq =
    new PriorityQueue<>((a, b) -> {
        if (a.getValue().equals(b.getValue())) {
            // same freq → smaller key should be lower priority
            return a.getKey() - b.getKey();
        } else {
            // smaller freq → lower priority
            return a.getValue() - b.getValue();
        }
    });
             for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > x) pq.poll();
             }
            int sum=0;
             while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> e = pq.poll();
            sum += e.getKey() * e.getValue();
        }
        ans[index++]=sum;
        }
           
           j++;
           if(j-i+1>k){
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
            if (map.get(nums[i]) <= 0) {
            map.remove(nums[i]);
            }
            i++;
           }
        }
        return ans;
    }
}