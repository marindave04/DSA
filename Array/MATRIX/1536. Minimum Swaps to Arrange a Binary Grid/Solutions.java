class Solution {
    public int minSwaps(int[][] grid) {
       int n=grid.length;
       int[] nums=new int[n];
       //calculate the trailing zeroes in each row
       for(int i=0;i<n;i++){
        for(int j=n-1;j>=0;j--){
            if(grid[i][j]==0){
                nums[i]++;
            }else{
                break;
            }

        }
       }
       int swap=0;
       for(int i=0;i<n;i++){
        int need=n-i-1;
        if(need<=nums[i]) continue;
        boolean flag=false;
        for(int j=i+1;j<n;j++){
            if(nums[j]>=need){
                flag=true;
                swap+=j-i;
                bubbleSort(nums,i,j);
                break;
            }
        }
        if(!flag) return -1;
       }
       return swap;
    }
    static void bubbleSort(int[] nums,int s,int e){
        for(int i=e;i>s;i--){
            int temp=nums[i];
            nums[i]=nums[i-1];
            nums[i-1]=temp;
        }
    }
}
