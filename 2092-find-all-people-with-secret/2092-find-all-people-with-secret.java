class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        //hum hr ek time per time se mtlb increasing order of time per kon kon si meeting ho rhi hai usko ek orderes map yaani tree map me store krenge 
        Map<Integer,List<int[]>> map=new TreeMap<>();
        for(int i=0;i<meetings.length;i++){
            int x=meetings[i][0];
            int y=meetings[i][1];
            int t=meetings[i][2];
            map.computeIfAbsent(t,k-> new ArrayList<>()).add(new int[]{x,y});
        }
        //ab hum ek boolean array me ye store kr lenge ki kon kon se person ko secret pta hai
        boolean[] knowsSecret=new boolean[n];
        knowsSecret[0]=true;
        knowsSecret[firstPerson]=true;
        //ab hum apne ordered time wale map ko traverse krenge 
        for(int time:map.keySet()){
           Map<Integer, List<Integer>> meet = new HashMap<>();
            for (int[] meeting : map.get(time)) {
                int x = meeting[0], y = meeting[1];
                meet.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                meet.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }
            //ab hr time ke liye respective adjencylist ko check krenge
            Set<Integer> start = new HashSet<>();
            for (int[] meeting : map.get(time)) {
                int x = meeting[0], y = meeting[1];
                if (knowsSecret[x]) {
                    start.add(x);
                }
                if (knowsSecret[y]) {
                    start.add(y);
                }
            }
            Queue<Integer> q = new LinkedList<>(start);
            while (!q.isEmpty()) {
                int person = q.poll();
                for (int nextPerson : meet.getOrDefault(person, new ArrayList<>())) {
                    if (!knowsSecret[nextPerson]) {
                        knowsSecret[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
         List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }
        return result;
     }
}