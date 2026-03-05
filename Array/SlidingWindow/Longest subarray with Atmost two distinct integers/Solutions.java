//[Naive Approach] Generate all subarrays - O(n^3) Time and O(1) Space
class Solution {
    public int totalElements(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                HashSet<Integer> set=new HashSet<>();
                for(int k=i;k<=j;k++){
                    set.add(arr[k]);
                }
                if(set.size()<=2) {
                    count=Math.max(count,j-i+1);
                }
            }
        }
        return count;
    }
}
//[Better Approach] Generate all subarrays, efficiently check distinct elements - O(n^2) Time and O(1) Space
class Solution {
    public int totalElements(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<arr.length;j++){
                set.add(arr[j]);
                if(set.size()<=2){
                    count=Math.max(count,j-i+1);
                }
            }
        }
        return count;
    }
}
//[Expected Approach] Using Sliding Window - O(n) Time and O(1) Space
class Solution {
    public int totalElements(int[] arr) {
        // code here
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>2){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                   
                }
               i++;
            } 
            count=Math.max(count,j-i+1);
            j++;
        }
        return count;
    }
}
