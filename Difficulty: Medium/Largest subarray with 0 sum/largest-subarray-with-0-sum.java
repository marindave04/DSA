class Solution {
    int maxLength(int arr[]) {
        // code here
         HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            
            if(map.containsKey(sum-0)){
                max=Math.max(max,i-map.get(sum-0));
            }
             map.putIfAbsent(sum, i);
        }
        return max;
    }
}