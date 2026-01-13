class Solution {
    public double separateSquares(int[][] squares) {
        double low=0;
        double high=0;
        for(int[] row:squares){
            int y=row[1];
            int l=row[2];
            high=Math.max(high,y+l);
        }
        double ta=0;
        for(int[] row:squares){
            ta=(double) ta+(double)row[2]*row[2];
        }
        double temp=1e-5;
        while(Math.abs(high-low)>temp){
            double mid=low+(high-low)/2;
            if(check(mid,squares,ta)){
                high=mid;
            }else{
                low=mid;
            }
        }
       return high;
    }
    static boolean check(double mid,int[][] squares,double ta){
        double ba=0.0;
        for(int[] row:squares){
            double by=row[1];
            double ty=(double)row[1]+row[2];
            double l=row[2];
            if(mid>=ty){
                ba=(double)ba+(double)l*l;
            }else if(mid>by){
                ba= (double)ba+(double)(l*(mid-by));
            }
        }
        return ba>=ta/2.0;
    }
}