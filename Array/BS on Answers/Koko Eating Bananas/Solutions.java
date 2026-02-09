class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int s=1;
        int e=Arrays.stream(arr).max().getAsInt();
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(check(arr,k,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public static  boolean  check(int[] arr, int k,int mid){
        int sum=Arrays.stream(arr).sum();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<mid){
                sum=sum-arr[i];
                count++;
            }else{
                sum=sum-arr[i];
                int rem=arr[i]%mid;
                if(rem>0){
                    count=count+arr[i]/mid+1;
                }else{
                    count=count+arr[i]/mid;
                }
            }
        }
        return (count<=k && sum==0);
    }
}
