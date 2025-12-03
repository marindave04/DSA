class Solution {
    public int countTrapezoids(int[][] points) {
        int n=points.length;
        int result =0;
       HashMap<Double,List<Double>> map=new HashMap<>();
        HashMap<Integer, List<Double>> map2 = new HashMap<>();

       for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
            int x1=points[i][0];
            int y1=points[i][1];
            int x2=points[j][0];
            int y2=points[j][1];
            int dx=x2-x1;
            int dy=y2-y1;
            double slope;
            double intercept;
            if(dx==0){
              slope=1000000007;
              intercept=x1;
            }else{
                slope=(double)dy/dx;
                intercept=(double)(y1*dx-x1*dy)/dx;
            }
            if (slope == -0.0) slope = 0.0;
            if (intercept == -0.0) intercept = 0.0;
            map.putIfAbsent(slope,new ArrayList<>());
            map.get(slope).add(intercept);
             int midPointKey = (x1 + x2) * 10000 + (y1 + y2);
             map2.putIfAbsent(midPointKey,new ArrayList<>());
            map2.get(midPointKey).add(slope);

          }
       } 
       for (List<Double> interceptList : map.values()) {
            if (interceptList.size() <= 1) continue;

            TreeMap<Double, Integer> freq = new TreeMap<>();
            for (double b : interceptList)
                freq.put(b, freq.getOrDefault(b, 0) + 1);

            int prefix = 0;
            for (int count : freq.values()) {
                result += prefix * count;
                prefix += count;
            }
        }
          for (List<Double> slopeList : map2.values()) {
            if (slopeList.size() <= 1) continue;

            TreeMap<Double, Integer> freq = new TreeMap<>();
            for (double s : slopeList)
                freq.put(s, freq.getOrDefault(s, 0) + 1);

            int prefix = 0;
            for (int count : freq.values()) {
                result -= prefix * count;
                prefix += count;
            }
        }
        return result;
    }
}