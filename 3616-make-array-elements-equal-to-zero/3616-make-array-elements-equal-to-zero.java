class Solution {
    public int countValidSelections(int[] nums) {
        //simple simulation
        int[] originalNums = nums.clone();
        int n=nums.length;
        int curr=0;
        int counter=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr=i;
                int[] clone1=nums.clone();
                int[] clone2=nums.clone();
                 int a = chooseRight(clone1, 0, curr); 
                 int b = chooseLeft(clone2, 0, curr);
                 counter+=a+b;
            }else{
                continue;
            }
        }
        return counter;
    }
    static int chooseRight(int[] nums,int count,int curr){
        int n=nums.length;
        boolean right=true;
        boolean left =false;
        while(curr>=0 && curr<n){
        if(nums[curr]==0){
        if(right) curr++;
        if(left) curr--;
        }else if(nums[curr]>0){
        nums[curr]--;
        if(right){
        right=false;
        left=true;
        curr--;
        }else{
        right=true;
        left=false;
        curr++;
        }
        }
        }
        boolean temp=true;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                temp=false;
                break;
            }
        }
        if(temp) count++;
        return count;
    }
    static int chooseLeft(int[] nums,int count,int curr){
        int n=nums.length;
        boolean right=false;
        boolean left =true;
        while(curr>=0 && curr<n){
        if(nums[curr]==0){
        if(right) curr++;
        if(left) curr--;
        }else if(nums[curr]>0){
        nums[curr]--;
        if(right){
        right=false;
        left=true;
        curr--;
        }else{
        right=true;
        left=false;
        curr++;
        }
        }
        }
         boolean temp=true;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                temp=false;
                break;
            }
        }
        if(temp) count++;
        return count;
    }
}
