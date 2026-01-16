class Solution {
    static int mod=1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
       ArrayList<Integer> h=new ArrayList<>();
       ArrayList<Integer> v=new ArrayList<>();
       for(int num:hFences) h.add(num);
       for(int num:vFences) v.add(num);
       h.add(1);
       h.add(m);
       v.add(n);
       v.add(1);
       Collections.sort(h);
       Collections.sort(v);
       HashSet<Integer> width=new HashSet<>();
       for(int i=0;i<v.size();i++){
        for(int j=i+1;j<v.size();j++){
            width.add(v.get(j)-v.get(i));
        }
       }
       int max=-1;
       for(int i=0;i<h.size();i++){
        for(int j=i+1;j<h.size();j++){
            int height=Math.abs(h.get(j)-h.get(i));
            if(width.contains(height)){
                max=Math.max(height,max);
            }
        }
       }
       if(max==-1) return -1;
       long area=(long)max*max;
       return (int)(area%mod);
    }
}