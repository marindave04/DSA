class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        if(numRows==1) {
            list.add(new ArrayList<>());
             list.get(0).add(1);
             return list;
        }
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=1;i<numRows-1;i++){
            list.get(i+1).add(1);
            for(int j=1;j<list.get(i).size();j++){
                int x=list.get(i).get(j)+list.get(i).get(j-1);
                list.get(i+1).add(x);
            }
            list.get(i+1).add(1);
        }
        return list;
    }
}