class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> one=new ArrayList<>();
        ArrayList<Integer> two=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%3==1)one.add(nums[i]);
            if(nums[i]%3==2)two.add(nums[i]);
        }
        Collections.sort(one);
        Collections.sort(two);
        int sum=Arrays.stream(nums).sum();
        int rem=sum%3;
        if(rem==0) return sum;
        if(rem==1){
            int remove1=0;
            int remove2=0;
           if(one.size()>=1) {
             remove1=one.get(0);
           }
            int sum1=sum-remove1;
           if(two.size()>=2) {
             remove2=two.get(0)+two.get(1);
           }
            int sum2=sum-remove2;
            if(sum2==sum) return sum1;
            if(sum1==sum) return sum2;
            return (int)Math.max(sum1,sum2);
        }
        if(rem==2){
            int remove1=0;
            int remove2=0;
            if(two.size()>=1) {
                 remove1=two.get(0);
            }
            int sum1=sum-remove1;
            if(one.size()>=2){
                 remove2=one.get(0)+one.get(1);
            }
            int sum2=sum-remove2;
            if(sum2==sum) return sum1;
            if(sum1==sum) return sum2;
             return (int)Math.max(sum1,sum2);
        }
        return 0;
    }
}