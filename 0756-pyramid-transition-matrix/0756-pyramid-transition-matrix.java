class Solution {
     private Map<String, Boolean> dp = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> map=new HashMap<>();
        for(String pattern:allowed){
            String key=pattern.substring(0,2);
            Character ch=pattern.charAt(2);
            map.computeIfAbsent(key,k-> new ArrayList<>()).add(ch);

        }
        return solve(bottom,map,0,new StringBuilder());
    }
    private boolean solve(String current,Map<String,List<Character>> map,int idx,StringBuilder above){
        if(current.length()==1) return true;
        String temp=current+"_"+idx+"_"+above.toString();
        if(dp.containsKey(temp)){
            return dp.get(temp);
        }
        if(idx==current.length()-1){
            boolean result=solve(above.toString(),map,0,new StringBuilder());
            dp.put(temp,result);
            return result;
        }
        String pair=current.substring(idx,idx+2);
        if(!map.containsKey(pair)){
            dp.put(temp,false);
            return false;
        }
        for(Character ch:map.get(pair)){
            above.append(ch);
            if(solve(current,map,idx+1,above)){
                dp.put(temp,true);
                return true;
            }
            above.deleteCharAt(above.length()-1);
        }
        dp.put(temp,false);
        return false;
    }
}