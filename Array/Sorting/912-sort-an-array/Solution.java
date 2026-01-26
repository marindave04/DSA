// Approach: Sorting  
// Time Complexity: O(n log n)  
// Space Complexity: O(1)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       Arrays.sort(arr);
       int min=Integer.MAX_VALUE;
       for(int i=0;i<arr.length-1;i++){
          int diff=(int)Math.abs(arr[i+1]-arr[i]);
          min=Math.min(min,diff);
       } 
       List<List<Integer>> list=new ArrayList<>();
       for(int i=0;i<arr.length-1;i++){
        if((int)Math.abs(arr[i+1]-arr[i])==min){
            list.add(new ArrayList<>(Arrays.asList(arr[i],arr[i+1])));
        }
       }
       return list;
    }
}
