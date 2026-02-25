class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int n=a1.length;
        int p1=0;
        int p2=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            p1+=a1[i];
            p2+=a2[i];
            int diff=p1-p2;
            if(diff==0){
                max=Math.max(max,i+1);
            }else if(map.containsKey(diff)){
                max=Math.max(max,i-map.get(diff));
            }else{
                map.put(diff,i);
            }
           
        }
        return max;
    }
}
