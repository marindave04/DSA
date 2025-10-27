class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int count=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp=ones(bank[i]);
            if(temp!=0){
                list.add(temp);
            }
        }
        for(int i=0;i<list.size()-1;i++){
            int product=list.get(i)*list.get(i+1);
            count=count+product;
        }
        return count;
    }
    static int ones(String a){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='1') count++;
        }
        return count;
    }
}