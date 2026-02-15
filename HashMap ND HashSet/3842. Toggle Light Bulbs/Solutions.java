class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> list=new ArrayList<>();
        Collections.sort(bulbs);
        HashMap<Integer,Integer> map=new HashMap<>();
      //  HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<bulbs.size();i++){
            int bulb=bulbs.get(i);
            map.put(bulb,map.getOrDefault(bulb,0)+1);
           // set.add(bulb);
        }
         for(int i=0;i<bulbs.size();i++){
            int bulb=bulbs.get(i);
             if(i>0 && bulb==bulbs.get(i-1)) continue;
           if(map.get(bulb)%2!=0){
               list.add(bulb);
           }
        }
        Collections.sort(list);
        return list;
    }
}
