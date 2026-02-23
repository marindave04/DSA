class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        HashSet<Integer> set=new HashSet<>();
         ArrayList<Integer> list=new  ArrayList<>() ;
         int i=0;
         int j=0;
         while(i<a.length || j<b.length){
             if(i<a.length && !set.contains(a[i])){
                 list.add(a[i]);
             }
            if(i<a.length) set.add(a[i]);
             if(j<b.length && !set.contains(b[i])){
                 list.add(b[i]);
             }
            if(j<b.length) set.add(b[i]);
             i++;
             j++;
         }
         return list;
    }
}
