class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;

        TreeSet<int[]> min= new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

         TreeSet<int[]> remaining= new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        long sum=0;
        int i=1;
        long ans=Long.MAX_VALUE;
        while(i<n && i-dist<1){
            int[] curr=new int[]{nums[i],i};
            min.add(curr);
            sum+=nums[i];
            if(min.size()>k-1){
                int[] max=min.pollLast();
                sum-=max[0];
                remaining.add(max);
            }
            i++;
        }
        while(i<n){
           int[] curr=new int[]{nums[i],i};
            min.add(curr);
            sum+=nums[i];
            if(min.size()>k-1){
                int[] max=min.pollLast();
                sum-=max[0];
                remaining.add(max);
            }
            ans=Math.min(ans,sum);
            int idx=i-dist;// removed index
            int[] removed=new int[]{nums[idx],idx};
            if(min.remove(removed)){
                sum-=nums[idx];
                if(!remaining.isEmpty()){
                    int[] promote=remaining.pollFirst();
                    min.add(promote);
                    sum+=promote[0];
                }
            }else{
                remaining.remove(removed);
            }
            i++;
        }
        return nums[0] + ans;
    }
}
