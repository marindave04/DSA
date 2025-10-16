class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
             int key = ((nums[i] % value) + value) % value; 
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int mex=0;
        while(map.getOrDefault(mex % value, 0) > 0){
            map.put(mex%value,map.get(mex%value)-1);
            mex++;
        }
        return mex;
    }
}