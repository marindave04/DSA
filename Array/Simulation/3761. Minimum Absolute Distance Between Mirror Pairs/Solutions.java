/*
| Approach                                           | Time Complexity | Space Complexity |
| -------------------------------------------------- | --------------- | ---------------- |
| **Brute Force (Reverse Number + Pair Comparison)** | **O(n² × d)**   | **O(1)**         |

*/
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int target=rev(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[j]){
                    min=Math.min(min,Math.abs(i-j));
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    static int rev(int n){
        int x=0;
        while(n>0){
            int rem=n%10;
            x=x*10+rem;
            n=n/10;
        }
        return x;
    }
}

/*
| Approach                                                | Time Complexity | Space Complexity |
| ------------------------------------------------------- | --------------- | ---------------- |
| **HashMap + Reverse Number (Single Pass Optimization)** | **O(n × d)**    | **O(n)**         |

*/
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            int target=rev(nums[i]);
            if(map.containsKey(target)){
                min=Math.min(min,Math.abs(i-map.get(target)));
            }
            map.put(nums[i],i);
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    static int rev(int n){
        int x=0;
        while(n>0){
            int rem=n%10;
            x=x*10+rem;
            n=n/10;
        }
        return x;
    }
}
