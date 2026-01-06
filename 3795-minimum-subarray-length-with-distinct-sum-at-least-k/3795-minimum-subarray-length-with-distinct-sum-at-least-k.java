class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        long uniqueSum=0;
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        while(j<n){
            if(!map.containsKey(nums[j])){
                uniqueSum=(long)uniqueSum+nums[j];
                }
            
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           
            while(uniqueSum>=k){
                min=Math.min(min,j-i+1);
                if( map.get(nums[i])==1){
                    uniqueSum=(long)uniqueSum-nums[i];
                    map.remove(nums[i]);
                  
                    
                }else{
                    map.put(nums[i],map.get(nums[i])-1);
                   
                }
                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
}