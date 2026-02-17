//BRUTE FORCE

class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
       // toh mera approach ye hai ki humko ye dekhna hai ki at any point of time kitne intervals overlap ho rhe hai
       //toh hum brute force trike se sochenge ki thik hai hum saare point of time per check kr lete hai jha per maximum interval exist krega whi hamara answer hoga
       int max=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
       for(int[] row:arr){
           min=Math.min(min,row[0]);
           max=Math.max(max,row[1]);
       }
       int ans=0;
       for(int i=min;i<max;i++){
           int count=0;
           for(int[] row:arr){
               if(row[0]<=i && row[1]>=i) count++;
           }
           ans=Math.max(ans,count);
       }
       return ans;
    }
}

//OPTIMAL->LINE SWEEP


class Solution {
    public static int overlapInt(int[][] arr) {
        // code here
        int n=arr.length;
        int[][] events=new int[2*n][2];
        int idx=0;
        for(int i=0;i<n;i++){
            events[idx][0]=arr[i][0];
            events[idx++][1]=1;
            events[idx][0]=arr[i][1];
            events[idx++][1]=-1;
        }
        Arrays.sort(events,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return b[1]-a[1];
        });
        int max=0;
        int count=0;
        for(int i=0;i<events.length;i++){
            if(events[i][1]==1){
                count++;
            }else{
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
