class Solution {
    public long maxPower(int[] stations, int r, int k) {
        //finding diff array
        int n=stations.length;
        long[] diff=new long[n];
        for(int i=0;i<n;i++){
            int left=Math.max(0,i-r);
            int right=i+r+1;
            diff[left] +=stations[i];
            if(right<n) diff[right]-=stations[i];

        }
         long left = Arrays.stream(stations).min().getAsInt();
        long right = Arrays.stream(stations).asLongStream().sum() + k;
        long result = 0;

        // Binary search
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, diff, r, k, n)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
    static boolean check(long mid,long[] diff,int r,int k,int n){
          long[] tempDiff = Arrays.copyOf(diff, n);
        long cumSum = 0;

        for (int i = 0; i < n; i++) {
            cumSum += tempDiff[i];

            if (cumSum < mid) {
                long need = mid - cumSum;
                if (need > k) {
                    return false;
                }

                k -= need;
                cumSum += need;

                // apply difference array logic
                if (i + 2L * r + 1 < n) {
                    tempDiff[(int)(i + 2L * r + 1)] -= need;
                }
            }
        }
        return true;
    }
}