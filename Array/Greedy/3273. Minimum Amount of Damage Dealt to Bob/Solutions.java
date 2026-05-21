/*
| Approach                                                                                                                          | Time           | Space    |
| --------------------------------------------------------------------------------------------------------------------------------- | -------------- | -------- |
| Compute attacks needed for each enemy, sort enemies greedily by `(moves / damage)` ratio, then simulate total accumulated damage. | **O(N log N)** | **O(N)** |

*/

class Solution {
    class Pair{
        double x;
        int index;
        Pair(double x,int index){
            this.x=x;
            this.index=index;
        }
    }
    public long minDamage(int power, int[] damage, int[] health) {
        List<Pair> orderOfKill=new ArrayList<>();
        int n=damage.length;
        for(int i=0;i<n;i++){
             double moves=Math.ceil((double)health[i]/power);
             orderOfKill.add(new Pair(moves/damage[i],i));
        }
        Collections.sort(orderOfKill,(a,b)->Double.compare(a.x,b.x));
        long sum=0;
        long ans=0;
        for(int num:damage){
            sum=(long)sum+num;
        }
        for(int i=0;i<n;i++){
            int idx=orderOfKill.get(i).index;
            double moves=Math.ceil((double)health[idx]/power);
            ans=(long)ans+sum*(long)moves;
            sum=(long)sum-damage[idx];
        }
        return ans;
    }
}
