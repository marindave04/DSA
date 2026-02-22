class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n=arr.length;
       int[] prefix=new int[n];
       prefix[0]=arr[0];
       for(int i=1;i<n;i++){
           prefix[i]=prefix[i-1]^arr[i];
       }
       HashMap<Integer,Integer> map=new HashMap<>();
      
       int count=0;
      for(int i=0;i<n;i++){
         int curr=prefix[i];
         if(curr==k) count++;
         int need=curr^k;
           if (map.containsKey(need)) {
                count += map.get(need);
            }
              map.put(curr, map.getOrDefault(curr, 0) + 1);
              
      }
      return count;
    }
}
