class Solution {
   public int lengthOfLIS(int[] nums) {
    //pateince sorting
    int n=nums.length;
   
    ArrayList<Integer> list=new ArrayList<>();
     for(int i=0;i<n;i++){
        //ab humko lower bound find krna hain kyu ki sorted list me jo smaller element aayega usko uski jgh rkhengeaur whi hmara lis bna dega
        int index=lowerBound(list,nums[i]);
        if(index==list.size()){
            list.add(nums[i]);
        }else {
            // replace 
            list.set(index,nums[i]);
        }
     }
     return list.size();
    }
    static int lowerBound( ArrayList<Integer> list,int x){
        int target=x;
        int s=0;
        int e=list.size()-1;
        int ans=list.size();
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target<=list.get(mid)){
                 ans=mid;
                 e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
}