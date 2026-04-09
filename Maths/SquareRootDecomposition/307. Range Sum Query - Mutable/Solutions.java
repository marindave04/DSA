/*

*/
class NumArray {
    int[] nums;
    int[] blocks;
    int n;
    int blockSize;
    public NumArray(int[] nums) {
        this.nums=nums;
        n=nums.length;
        blockSize=(int)Math.ceil(Math.sqrt(n));
        blocks=new int[blockSize];
        //building blocks
        for(int i=0;i<n;i++){
            int idx=i/blockSize;
            blocks[idx]+=nums[i];
        }
    }
    
    public void update(int index, int val) {
        int prev=nums[index];
        nums[index]=val;
        int temp=blocks[index/blockSize];
        temp=temp-prev;
        temp=temp+val;
        blocks[index/blockSize]=temp;
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        //case-1 left and right both in same block
        int startBlock=left/blockSize;
        int endBlock=right/blockSize;
        if(startBlock==endBlock){
            for(int i=left;i<=right;i++){
               sum+=nums[i];
            }
        }else{
            //case 2nd-left and right both are in different blocks
            //left
            int endOfStartBlock=((startBlock+1)*blockSize)-1;
            for(int i=left;i<=endOfStartBlock;i++){
                sum+=nums[i];
            }
            //middle
            
            for(int b=startBlock+1;b<=endBlock-1;b++){
                sum+=blocks[b];
            }
            //right
            int startOfEndBlock=endBlock*blockSize;
            for(int i=startOfEndBlock;i<=right;i++ ){
                sum+=nums[i];
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
