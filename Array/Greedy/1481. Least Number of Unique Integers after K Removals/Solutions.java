/*
| Approach                                                                                                                                                | Time           | Space    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Count frequencies using a hash map, sort the frequencies, then greedily remove numbers with the smallest frequencies until `k` deletions are exhausted. | **O(N log N)** | **O(N)** |

*/
class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] temp=new int[map.size()];
        int idx=0;
        for(int key:map.keySet()){
            int f=map.get(key);
            temp[idx++]=f;
        }
        Arrays.sort(temp);
        int unique=temp.length;
        for(int i=0;i<temp.length;i++){
            if(k>=temp[i]){
               k=k-temp[i];
               unique--;
            }else{
                break;
            }
        }
        return unique;
    }
}
