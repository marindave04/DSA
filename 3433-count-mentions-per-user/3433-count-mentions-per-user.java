class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];

         Collections.sort(events, (a, b) -> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }

            return Integer.compare(t1, t2);
        });

        int n = events.size();
        int[] offlineTime=new int[numberOfUsers];
        for(List<String> event:events){
            if(event.get(0).equals("MESSAGE")){
                applyTime(event,mentions,offlineTime);
            }else if (event.get(0).equals("OFFLINE")){
                int timeStamp=Integer.parseInt(event.get(1));
                int userId=Integer.parseInt(event.get(2));
                offlineTime[userId]=timeStamp;
            }
        }
        return mentions;
    }
    static void applyTime(List<String> event,int[] mentions,int[]offlineTime){
        int time=Integer.parseInt(event.get(1));
        String[] ids=event.get(2).split(" ");
        for(String id:ids){
            if(id.equals("ALL")){
                for(int i=0;i<mentions.length;i++) mentions[i]++;
            }else if(id.equals("HERE")){
                for(int i=0;i<mentions.length;i++){
                    if(offlineTime[i]==0 || (offlineTime[i]+60)<=time){
                        mentions[i]++;
                    }
                }
            }else{
                int userId=Integer.parseInt(id.substring(2));
                mentions[userId]++;
            }
        }
    }
}
