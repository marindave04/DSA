/*
| Approach                                                                                                                                 | Time           | Space    |
| ---------------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Sort array and greedily extend the reachable sum range; if current element is greater than reachable sum `+1`, that value is the answer. | **O(N log N)** | **O(1)** |

*/
class Solution {
    public int findSmallest(int[] arr) {
        // code here
        Arrays.sort(arr);
        int ans=1;
        int n=arr.length;
        int i=0;
        while(i<n && arr[i]<=ans){
            ans+=arr[i];
            i++;
        }
        return ans;
    }
}
