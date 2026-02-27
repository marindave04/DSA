// ## Approach – 1

// **Approach:**
// Use prefix counting to convert the condition into a difference problem (`diff = count1 - count2`) and use a HashMap to track earliest occurrences to find the longest valid subarray.

// **Concept Used:**
// Prefix Sum technique + HashMap for first occurrence storage.

// **Time Complexity:** O(n)
// **Space Complexity:** O(n)

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        
        // Build prefix counts
        if (arr[0] > k) count1[0] = 1;
        else count2[0] = 1;
        
        for (int i = 1; i < n; i++) {
            count1[i] = count1[i - 1];
            count2[i] = count2[i - 1];
            
            if (arr[i] > k) count1[i]++;
            else count2[i]++;
        }
        
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            
            int diff = count1[i] - count2[i];
            
            // Case 1: from index 0 to i valid
            if (diff > 0) {
                max = i + 1;
            }
            
            // Case 2: find earlier diff - 1
            if (map.containsKey(diff - 1)) {
                max = Math.max(max, i - map.get(diff - 1));
            }
            
            // store first occurrence only
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
        }
        
        return max;
    }
}
// Approach – 2

// Approach:
// Instead of using prefix arrays, maintain running counts of elements > k and <= k, compute diff = count1 - count2 on the fly, and use a HashMap to store the first occurrence of each diff to find the longest valid subarray.

// Concept Used:
// Prefix Difference technique (running count optimization) + HashMap for earliest index tracking.

// Time Complexity: O(n)
// Space Complexity: O(n)**

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int count1=0;
        int count2=0;
        
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if(arr[i]>k) count1++;
            if(arr[i]<=k) count2++;
            
            int diff = count1-count2;
            
            // Case 1: from index 0 to i valid
            if (diff > 0) {
                max = i + 1;
            }
            
            // Case 2: find earlier diff - 1
            if (map.containsKey(diff - 1)) {
                max = Math.max(max, i - map.get(diff - 1));
            }
            
            // store first occurrence only
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            }
        }
        
        return max;
    }
}
// Approach – 3

// Approach:
// Convert the condition into a running prefix sum by treating elements > k as +1 and <= k as -1. While iterating, maintain psum and use a HashMap to store the first occurrence of each prefix sum. If psum > 0, the subarray from 0 → i is valid; otherwise, check if (psum - 1) exists to find a longer valid subarray.

// Concept Used:
// Prefix Sum Transformation (1 / -1 trick) + HashMap for earliest prefix sum index tracking.

// Time Complexity: O(n)
// Space Complexity: O(n)**

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
             
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum=0;
        for (int i = 0; i < n; i++) {
          if(arr[i]>k) psum++;
          else psum--;
           if(psum>0){
               max=i+1;
           }
               if(map.containsKey(psum-1)){
                   max=Math.max(max,i-map.get(psum-1));
               }
           
           if(!map.containsKey(psum)){
               map.put(psum,i);
           }
        }
        
        return max;
    }
}
