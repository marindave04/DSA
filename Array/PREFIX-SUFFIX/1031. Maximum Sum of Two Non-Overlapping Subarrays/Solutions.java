/*
| Approach                                                                                                                                                                          | Time     | Space    |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------- | -------- |
| Use prefix/suffix maximum window sums to find the best non-overlapping subarrays. Solve once with `(x1, x2)` order and once after reversing the array to cover both arrangements. | **O(N)** | **O(N)** |

*/
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int x1, int x2) {
        int max1=solve(nums,x1,x2);
        reverse(nums);
        int max2=solve(nums,x1,x2);
        return Math.max(max1,max2);
    }
    static void reverse(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    static int solve(int[] nums, int x1, int x2){
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }
        int[] left=new int[n];
        int[] right=new int[n];
        int p=0;
        int q=x1-1;
        while(q<n){
            int windowSum=prefix[q]-(p>0 ? prefix[p-1] :0);
            left[q]=Math.max((q-1>=0 ?left[q-1] : 0),windowSum);
            q++;
            p++;
        }
        p=n-1;
        q=n-x2;
        while(q>=0){
            int windowSum=suffix[q]-(p+1<n ? suffix[p+1] : 0);
            right[q]=Math.max((q+1<n ? right[q+1]:0),windowSum);
            p--;
            q--;
        }
        int max=0;
        int i=0;
        int j=x1-1;
        int t=j+1;
        int s=t+x2-1;
        while(s<n && j!=t){
            max=Math.max(max,left[j]+right[t]);
            i++;
            j=t;
            t++;
            s++;
        }

        return max;
    }
}
