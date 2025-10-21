class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
             long t1=target-nums[i];
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                long t2=t1-nums[j];
                int p=j+1;
                int q=n-1;
                while(p<q){
                    if( t2>nums[p]+nums[q]){
                        p++;
                    }else if(t2<nums[p]+nums[q]){
                        q--;
                    }else{
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[p]);
                        triplet.add(nums[q]);
                        list.add(triplet);
                        while(p<q && nums[p]==nums[p+1]) p++;
                        while(p<q && nums[q]==nums[q-1]) q--;
                       
                    p++;
                    q--;
                    }
                }
            }
        }
        return list;
    }
}