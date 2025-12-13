class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        for(int i=0;i<code.length;i++){
            if(code[i].isEmpty()) continue;
            if(valid(code[i])){
                if(isActive[i] && validBusiness(businessLine[i])){
                    ans.add(code[i]);
                    temp.add(businessLine[i]);
                }
            }
        }
        List<String> result=sort(ans,temp);
        return result;
    }
    static boolean valid(String str){
         for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
    static boolean validBusiness(String str){
        Set<String> allowed = new HashSet<>(
            Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );
        return allowed.contains(str);
    }
    static List<String> sort(List<String> first, List<String> second){
         int n = first.size();
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            idx.add(i);
        }

        // sort indices using second list
         Collections.sort(idx, (i, j) -> {
            int cmp = second.get(i).compareTo(second.get(j));
            if (cmp != 0) return cmp;          // primary key
            return first.get(i).compareTo(first.get(j)); // secondary key
        });

        // build result for first list
        List<String> result = new ArrayList<>();
        for (int i : idx) {
            result.add(first.get(i));
        }

        return result;
    }
    }
