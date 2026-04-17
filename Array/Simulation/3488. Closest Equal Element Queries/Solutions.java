/*
| Approach                                                 | Time Complexity    | Space Complexity |
| -------------------------------------------------------- | ------------------ | ---------------- |
| **HashMap + Binary Search + Circular Distance Handling** | **O(n + q log k)** | **O(n)**         |

*/
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
     
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
             map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int q:queries){
            int key=nums[q];
            ArrayList<Integer> list=map.get(key);
            int size=list.size();
            if(size<=1){
                ans.add(-1);
                continue;
            }
            int pos=Collections.binarySearch(list,q);
            //int res=Integer.MAX_VALUE;
            //right
            int right=list.get((pos+1)%size);
            int d=Math.abs(q-right);
            int cd=Math.abs(n-d);
            int min1=Math.min(d,cd);

            int left=list.get((pos-1+size)%size);
            d=Math.abs(q-left);
            cd=Math.abs(n-d);
            int min2=Math.min(d,cd);
           ans.add(Math.min(min1,min2));
        }
        return ans;
    }
}
