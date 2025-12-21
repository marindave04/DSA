class Solution {
    public int minDeletionSize(String[] strs) {
     int n=strs.length;
     int count=0;
     boolean[] bool=new boolean[n-1];
     for(int i=0;i<strs[0].length();i++){
        boolean flag=false;
        for(int j=0;j<n-1;j++){
           if(!bool[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
            flag=true;
            count++;
            break;
           }
        }
        if(flag){
            continue;
        }
            
            for(int k=0;k<n-1;k++){
                bool[k]=bool[k]| strs[k].charAt(i)< strs[k+1].charAt(i);
            }
        
     }
     return count;
    }
}