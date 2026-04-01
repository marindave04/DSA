/*
| Approach                                                 | Time Complexity | Space Complexity |
| -------------------------------------------------------- | --------------- | ---------------- |
| **Greedy Construction + Validation (T & F constraints)** | **O(n × m)**    | **O(n + m)**     |

*/
class Solution {
    public String generateString(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int len=m+n-1;
        char[] word=new char[len];
        boolean[] change=new boolean[len];
        // fill this word with $
        for(int i=0;i<len;i++){
        word[i]='$';
        }
        //Now processing 'T';
        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                int idx=i;
                for(int j=0;j<str2.length();j++){
                    if(word[idx]!='$' && str2.charAt(j)!=word[idx]){
                        return "";
                    }
                    word[idx]=str2.charAt(j);
                    idx++;
                }
            }
        }
        //fill the remainig spaces with 'a'
        for(int i=0;i<len;i++){
             if(word[i]=='$'){
                word[i]='a';
                change[i]=true;
             }
        }
        //process f
        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                if(isSame(word,i,m,str2)){
                    boolean changed=false;
                    for(int k=i+m-1;k>=i;k--){
                        if(change[k]){
                            word[k]='b';
                            change[k]=false;
                            changed=true;
                            break;
                        }
                    }
                    if(!changed) return "";
                }
                
            }
        }
        return new String(word);
    }
    static boolean isSame(char[] word,int s,int m,String str2){
         for(int i=0;i<m;i++){
            if(word[s]!=str2.charAt(i)) return false; 
            s++;
         }
         return true;
    }
}
