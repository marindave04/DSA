class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int x=-1;
        int y=-1;
        for(int i=0;i<nums.length-1;i++){
             x=nums[i];
            int f1=map.get(x);
            for(int j=i+1;j<nums.length;j++){
                if(x==nums[j]) continue;
                if(f1!=map.get(nums[j])){
                    y=nums[j];
                    break;
                }
            }
            if(x!=-1 && y!=-1) break;
        }
        int[] ans=new int[2];
        if(x!=-1 && y!=-1){
            ans[0]=x;
            ans[1]=y;
        }else{
            ans[0]=-1;
            ans[1]=-1;
        }
        return ans;
    }
}
