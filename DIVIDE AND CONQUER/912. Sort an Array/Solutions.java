class Solution {
    public int[] sortArray(int[] nums) {
        solve(nums,0,nums.length-1);
        return nums;
    }
    static void solve(int[] nums,int l,int r){
        if(l>=r) return;
        int m=l+(r-l)/2;
        //left half
        solve(nums,l,m);
        //right half
        solve(nums,m+1,r);
        //merge
        merge(nums,l,m,r);
    }
    static void merge(int[] nums,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=nums[l+i];
        }
        for(int j=0;j<n2;j++){
            right[j]=nums[m+1+j];
        }
        //now merge and sort
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                nums[k++]=left[i];
                i++;
            }else{
                nums[k++]=right[j];
                j++;
            }
        }
        //ab remaining element ko add krenge
        while(i<n1){
            nums[k++]=left[i];
            i++;
        }
        while(j<n2){
            nums[k++]=right[j];
            j++;
        }
    }
}
