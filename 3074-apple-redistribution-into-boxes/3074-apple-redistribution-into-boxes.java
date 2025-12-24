class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Integer[] nums = Arrays.stream(capacity).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,Collections.reverseOrder());
        int sum=Arrays.stream(apple).sum();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(sum>nums[i]){
                count++;
                sum=sum-nums[i];
            }else{
                count++;
                return count;
            }
        }
        return 0;
    }
}