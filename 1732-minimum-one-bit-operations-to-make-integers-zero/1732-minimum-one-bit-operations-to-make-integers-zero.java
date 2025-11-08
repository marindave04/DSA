class Solution {
    public int minimumOneBitOperations(int n) {
        List<Integer> parts = new ArrayList<>();
        int power=0;
        while(n>0){
            if((n&1) == 1){
                parts.add(1<<power);
            }
            n=n>>1;
            power++;
        }
        Collections.reverse(parts);
        for(int i=0;i<parts.size();i++){
            
            parts.set(i,2*parts.get(i)-1);
        }
        int ans=0;
        for(int i=0;i<parts.size();i++){
             if(i%2==0) ans+=parts.get(i);
             else ans-=parts.get(i);
        }
        return ans;
    }
}