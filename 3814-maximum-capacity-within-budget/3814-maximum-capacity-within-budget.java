class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
      
      int n=costs.length;
      int[][] temp=new int [n][2];
      for(int i=0;i<n;i++){
        temp[i][0]=costs[i];
        temp[i][1]=capacity[i];
      }
      Arrays.sort(temp,(a,b)->a[0]-b[0]);
      for(int i=0;i<n;i++){
        costs[i]=temp[i][0];
        capacity[i]=temp[i][1];
      }
     int[] max=new int[n];
     max[0]=capacity[0];
     for(int i=1;i<n;i++){
        max[i]=Math.max(max[i-1],capacity[i]);
     }
     int ans=0;
     for(int i=0;i<n;i++){
        if(costs[i]<budget){
            ans=Math.max(ans,capacity[i]);
        }else{
            break;
        }
        int remaining= budget-costs[i];
        int idx=lowerBound(i,costs,remaining);
        if(idx>0){
            ans=Math.max(ans,capacity[i]+max[idx-1]);
        }
     }
     return ans;
    }
    static int lowerBound(int high,int[] costs,int rem){
        int s=0;
        int e=high;
        
        while(s<e){
            int mid=s+(e-s)/2;
            if(costs[mid]<rem){
                
                s=mid+1;
            }else{
              e=mid;
            }
        }
       return s; 
    }
}