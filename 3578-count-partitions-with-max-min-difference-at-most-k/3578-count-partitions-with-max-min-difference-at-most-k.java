class Solution {
    static int mod=1000000007;
    public int countPartitions(int[] nums, int k) {
       int n=nums.length;
       long[] dp=new long[n+1];
       long[] psum=new long[n+1];
       dp[0]=1;
       psum[0]=1;
        Deque<Integer> minQ=new ArrayDeque<>();
         Deque<Integer> maxQ=new ArrayDeque<>();
         int i=0;
         int j=0;
         while(j<n){
             while (!maxQ.isEmpty() && nums[j] > nums[maxQ.peekLast()])
                maxQ.pollLast();
                maxQ.addLast(j);

            while (!minQ.isEmpty() && nums[j] < nums[minQ.peekLast()])
                minQ.pollLast();
                minQ.addLast(j);

              while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                i++;
                if (!maxQ.isEmpty() && maxQ.peekFirst() < i) maxQ.pollFirst();
                if (!minQ.isEmpty() && minQ.peekFirst() < i) minQ.pollFirst();
            }  
            long val = (psum[j] - (i > 0 ? psum[i - 1] : 0) + mod ) % mod;

            dp[j + 1] = val;
            psum[j + 1] = (psum[j] + dp[j + 1]) % mod;

            j++; 
         }
         return (int)dp[n];
    }
}