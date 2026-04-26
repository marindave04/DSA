/*
| Approach                                                                                            | Time Complexity | Space Complexity |
| --------------------------------------------------------------------------------------------------- | --------------- | ---------------- |
| Count vowels frequency, mark vowel positions, then place vowels back in sorted frequency-wise order | **O(n × 26)**   | **O(1)**         |

*/
class Solution {
    public String sortVowels(String s) {
        int[] f=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                f[ch-'a']++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                sb.append('_');
            }else{
                sb.append(ch);
            }
            
        }
       int count=0;
        for(int i=0;i<26;i++){
            if(f[i]!=0) count++;
        }
        int p=0;
        
        for(int i=1;i<=count;i++){
            int max=0;
            for(int q=0;q<26;q++){
                if(f[q]>max){
                    max=f[q];

                }
            }
            int x=p;
            char ch='-';
            int idx=-1;
            for(int j=0;j<s.length();j++){
                   ch=s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                if(f[ch-'a']==max){
                    idx=ch-'a';
                    break;
                }
            }
            }
            int count2=max;
            while(x<sb.length()){
                if(sb.charAt(x)=='_' && count2>0){
                    sb.setCharAt(x,ch);
                    count2--;
                }
                if(count2==0){
                    break;
                }
                x++;
            }
            p=x;
            f[idx]=0;
        }
        return sb.toString();
    }
}
