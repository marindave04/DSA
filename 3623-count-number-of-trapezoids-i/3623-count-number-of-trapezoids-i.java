class Solution {
    public int countTrapezoids(int[][] points) {
        int n=points.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        final int mod=1000000007;
        for(int i=0;i<n;i++){
            int y=points[i][1];
            map.put(y,map.getOrDefault(y,0)+1);
        }
        long ans=0;
        long previousEdges=0;
        for(int x:map.values()){
           long edges=((long)x*(x-1))/2;
           ans=(ans+edges*previousEdges)%mod;
           previousEdges =   (previousEdges+edges)%mod;
        } 
        return (int) ans;
    }
}