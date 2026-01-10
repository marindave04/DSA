class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        //count opposite pairs #01 and #10
        int a01=0;
        int b10=0;
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)=='0' && t.charAt(j)=='1'){
                a01++;
            }else if(s.charAt(i)=='1' && t.charAt(j)=='0'){
                b10++;
            }
            i++;
            j++;
        }
        long cost1=0;
        //count of opposite mismatch pair->p
        int p=(int)Math.min(a01,b10);
        //cost of each opposite pair
        for(int k=1;k<=p;k++){
            cost1=(long)cost1+(long)Math.min(swapCost,2*flipCost);
        }
        a01--;
        b10--;
        //count remaining pairs
        int r=(int)Math.abs(a01-b10);
        long cost2=0;
        if(r%2==1){
            cost2=(long)cost2+(long)(flipCost);
            r=r-1;

        }
        while(r!=0){
            cost2=(long)cost2+(long)Math.min(crossCost + swapCost , 2 * flipCost);
            r=r-2;
        }
        return (long)(cost1+cost2);

    }
}