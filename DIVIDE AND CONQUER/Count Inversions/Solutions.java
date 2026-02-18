//Brute force
class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]) count++;
            }
        }
        return count;
    }
}
//optima
class Solution {
    static int inversionCount(int nums[]) {
        // Code Here
        return solve(nums,0,nums.length-1);
        
        
    }
    
    static int solve(int[] nums,int l,int r){
        int count=0;
        if(l<r){
            int m=l+(r-l)/2;
        //left half
        count+=solve(nums,l,m);
        //right half
       count+= solve(nums,m+1,r);
        //merge
       count+= merge(nums,l,m,r);
        }
        return count;
    }
    static int merge(int[] nums,int l,int m,int r){
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
        int count=0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                nums[k++]=left[i];
                i++;
            }else{
                count+=n1-i;
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
        return count;
    }
}
