// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            
            if(map.containsKey(sum-k)){
                max=Math.max(max,i-map.get(sum-k));
            }
             map.putIfAbsent(sum, i);
        }
        return max;
    }
}
