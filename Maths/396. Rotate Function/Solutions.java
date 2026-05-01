/*
| Approach                                                                                                                                                                   | Time Complexity | Space Complexity |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Compute initial rotation value `F(0)` and total sum, then use recurrence relation `F(k)=F(k-1)+sum-n*lastRotatedElement` to generate all rotation values and track maximum | **O(n)**        | **O(n)**         |

*/
class Solution {
    public int maxRotateFunction(int[] nums) {
    int n=nums.length;
    int[] t=new int[n];
    int sum=0;
    for(int i=0;i<n;i++){
        t[0]=t[0]+(i*nums[i]);
        sum+=nums[i];
    }
    int max=t[0];
    for(int i=1;i<n;i++){
        t[i]=t[i-1]+sum-n*nums[n-i];
        max=Math.max(max,t[i]);
    }
    return max;
    }
}
